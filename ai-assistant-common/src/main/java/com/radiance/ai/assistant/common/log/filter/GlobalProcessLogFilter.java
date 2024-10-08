package com.radiance.ai.assistant.common.log.filter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radiance.ai.assistant.common.properties.LogProperties;
import com.radiance.ai.assistant.domain.enums.LogTypeEnum;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 全局流程日志过滤器
 *
 * @author juncong.sh
 * @date 2023/6/19 11:01
 * @since 1.0.0
 */
public class GlobalProcessLogFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(GlobalProcessLogFilter.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String GET = "GET";
    private static final String COMMA = ",";
    private static final String ASTERISK = "*";
    private static final String CONTENT_TYPE_FORM_DATA = "multipart/form-data";
    private final Set<String> excludeUrisSet = new HashSet<>();
    private final Set<String> prefixExcludeUrisSet = new HashSet<>();
    private final LogProperties logProperties;

    public GlobalProcessLogFilter(LogProperties logProperties) {
        this.logProperties = logProperties;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            if (StringUtils.isNotBlank(logProperties.getExcludeUris())) {
                String[] excludeUrisArray = logProperties.getExcludeUris().split(COMMA);
                for (String uri : excludeUrisArray) {
                    if (uri.contains(ASTERISK)) {
                        // 前缀匹配
                        prefixExcludeUrisSet.add(uri.substring(0, uri.indexOf(ASTERISK) - 1));
                    } else {
                        // 等值匹配
                        excludeUrisSet.add(uri);
                    }
                }
                excludeUrisSet.addAll(Arrays.asList(excludeUrisArray));
            }
        } catch (Exception e) {
            excludeUrisSet.clear();
            log.warn("GlobalProcessLogFilter.init() warn:{}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        // 包装 request 和 response
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);
        // 获取请求的 content-type
        String contentType = requestWrapper.getContentType();

        try {
            // 不验证排除的 uri
            String requestUri = ((HttpServletRequest) servletRequest).getRequestURI();
            if (checkPrefix(requestUri) || excludeUrisSet.contains(requestUri)) {
                filterChain.doFilter(requestWrapper, responseWrapper);
                return;
            }
            filterChain.doFilter(requestWrapper, responseWrapper);
            byte[] responseData = responseWrapper.getContentAsByteArray();
            String response = new String(responseData, StandardCharsets.UTF_8);
            String host = servletRequest.getLocalAddr();
            int port = servletRequest.getLocalPort();
            String scheme = servletRequest.getScheme();
            String method = ((HttpServletRequest) servletRequest).getMethod();
            byte[] requestData = requestWrapper.getContentAsByteArray();
            String request = new String(requestData, StandardCharsets.UTF_8);
            // 设置 params
            String params = "";
            if (GET.equalsIgnoreCase(method)) {
                Map<String, String[]> parameterMap = servletRequest.getParameterMap();
                // 适配格式
                JSONObject paramsJson = new JSONObject(true);
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    if (entry.getValue().length > 1) {
                        paramsJson.put(entry.getKey(), entry.getValue());
                    } else {
                        paramsJson.put(entry.getKey(), entry.getValue()[0]);
                    }
                }
                params = paramsJson.toJSONString();
            } else {
                params = request;
                // form-data 格式参数处理
                if (StringUtils.isBlank(params) && !ObjectUtils.isEmpty(contentType) && contentType.contains(CONTENT_TYPE_FORM_DATA)) {
                    params = getFormDataParams(requestWrapper);
                }
                // 如果没有结果，跟 GET 的返回保持一致，返回一个空的 json
                if (StringUtils.isBlank(params)) {
                    params = new JSONObject(true).toJSONString();
                }
            }
            // 记录日志
            log.info("{} - URL: {}, HTTP Method: {}, Params: {}, Time: {} ms, Result: {}",
                    LogTypeEnum.PROCESS.getValue(), getUrl(scheme, host, port, requestUri), method, formatParams(params),
                    (System.currentTimeMillis() - start), response);
        } catch (Exception e) {
            log.warn("GlobalProcessLogFilter.doFilter warn:{}", e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            // 回写响应数据
            responseWrapper.copyBodyToResponse();
        }
    }

    /**
     * 获取 form-data 格式中的参数
     *
     * @param requestWrapper 请求包装对象
     * @return 返回参数
     * @author juncong.sh
     * @date 2024/2/29 21:03
     * @since 1.0.3
     */
    private static String getFormDataParams(ContentCachingRequestWrapper requestWrapper) throws IOException, ServletException {
        String params;
        JSONObject paramsJson = new JSONObject(true);
        Collection<Part> partCollection = requestWrapper.getParts();
        Map<String, String[]> parameterMap = requestWrapper.getParameterMap();
        for (Part part : partCollection) {
            if (parameterMap.containsKey(part.getName())) {
                paramsJson.put(part.getName(), parameterMap.get(part.getName())[0]);
            } else {
                if (StringUtils.isNotBlank(part.getContentType())) {
                    paramsJson.put(part.getName(), part.getSubmittedFileName());
                }
            }
        }
        params = paramsJson.toJSONString();
        return params;
    }

    /**
     * 格式化参数
     *
     * @param params 参数
     * @return 返回格式化结果
     * @author juncong.sh
     * @date 2023/9/19 15:17
     * @since 1.0.2
     */
    private String formatParams(String params) {
        // 匹配空格或换行
        if (StringUtils.isNotBlank(params)) {
            String pattern = "\\s+|\\n+";
            return params.replaceAll(pattern, "");
        }
        return params;
    }

    /**
     * 前缀匹配检查
     *
     * @param requestUri 请求 URI
     * @return 返回判断结果，true-请求 URI 前缀有指定值，false-请求 URI 前缀无指定值
     * @author juncong.sh
     * @date 2023/6/19 20:56
     * @since 1.0.0
     */
    private boolean checkPrefix(String requestUri) {
        for (String prefix : prefixExcludeUrisSet) {
            if (requestUri.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取请求 URL
     *
     * @param scheme 模式
     * @param host   机器 IP
     * @param port   端口号
     * @param uri    路径
     * @return 返回 URL
     * @author juncong.sh
     * @date 2023/6/19 14:06
     * @since 1.0.0
     */
    private String getUrl(String scheme, String host, int port, String uri) {
        return scheme + "://" + host + ":" + port + uri;
    }

}
