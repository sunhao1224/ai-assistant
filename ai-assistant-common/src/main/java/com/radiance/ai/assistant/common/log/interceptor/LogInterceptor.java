package com.radiance.ai.assistant.common.log.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 日志拦截器
 * <p>
 *
 * @author huli.lh
 * @date 2020/02/07
 */
public class LogInterceptor implements HandlerInterceptor {
    public static final String TRACE_ID = "TraceId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = null;
        if (null != request && StringUtils.isNotEmpty(request.getHeader(TRACE_ID))) {
            traceId = request.getHeader(TRACE_ID);
        } else {
            traceId = UUID.randomUUID().toString().replace("-", "");
        }
        MDC.put(TRACE_ID, traceId);
        // 响应头中加入 traceId，方便根据请求来追踪日志
        response.setHeader(TRACE_ID, traceId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(TRACE_ID);
    }
}
