package com.radiance.ai.assistant.common.exception.handler;

import com.radiance.ai.assistant.common.exception.runtime.*;
import com.radiance.ai.assistant.common.properties.GlobalExceptionSpringProperties;
import com.radiance.ai.assistant.domain.enums.ParamTypeEnum;
import com.radiance.ai.assistant.domain.enums.ResponseCodeEnum;
import com.radiance.ai.assistant.domain.vo.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;

/**
 * 全局捕获异常处理器
 *
 * @author juncong.sh
 * @date 2022/7/28 10:33
 * @since 1.0.0
 */
@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String FAILED_TO_CONVERT_PROPERTY_VALUE_OF_TYPE_PREFIX
            = "Failed to convert property value of type";

    private static final String FAILED_TO_CONVERT_VALUE_OF_TYPE_PREFIX = "Failed to convert value of type";

    private static final String REQUIRED_TYPE_CHN = "required type";

    private static final String CANNOT_DESERIALIZE_VALUE_OF_TYPE = "Cannot deserialize value of type";

    private static final String NOT_BLACK_CHN = "不能为空";

    public static final String COMMA_ENG = ",";

    public static final String COMMA_CHN = "，";

    public static final String COLON_ENG = ":";

    public static final String COLON_CHN = "：";

    public static final String FULL_STOP_ENG = ".";

    private final GlobalExceptionSpringProperties globalExceptionSpringProperties;

    public GlobalExceptionHandler(GlobalExceptionSpringProperties globalExceptionSpringProperties) {
        this.globalExceptionSpringProperties = globalExceptionSpringProperties;
    }

    /**
     * 400 异常处理
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh
     * @date 2022/7/28 17:39
     * @since 1.0.0
     */
    @ExceptionHandler(HttpRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseVO httpRequestException(HttpRequestException e) {
        log.warn(e.getMessage(), e);
        return ResponseVO.err(e.getCode(), e.getMessage());
    }

    /**
     * 401 异常处理
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh
     * @date 2022/7/28 17:56
     * @since 1.0.0
     */
    @ExceptionHandler(NonAuthorityException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseVO serverResponseException(NonAuthorityException e) {
        log.warn(e.getMessage(), e);
        return ResponseVO.err(e.getCode(), e.getMessage());
    }

    /**
     * 500 异常处理
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh
     * @date 2022/7/28 17:58
     * @since 1.0.0
     */
    @ExceptionHandler(HttpResponseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVO httpResponseException(HttpResponseException e) {
        log.warn(e.getMessage(), e);
        return ResponseVO.err(e.getCode(), e.getMessage());
    }

    /**
     * 500 异常处理-自定义未被捕获异常处理
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh
     * @date 2022/7/28 17:59
     * @since 1.0.0
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO baseException(BaseException e) {
        log.warn(e.getMessage(), e);
        return ResponseVO.err(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    /**
     * sql 异常处理
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh
     * @date 2022/7/28 18:28
     * @since 1.0.0
     */
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVO sqlException(SQLException e) {
        log.error(e.getMessage(), e);
        return ResponseVO.err(HttpStatus.INTERNAL_SERVER_ERROR.value(), "SQL Error:sql exception");
    }

    /**
     * 通用自定义异常捕获
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh
     * @date 2022/7/28 18:33
     * @since 1.0.0
     */
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO commonException(CommonException e) {
        log.warn(e.getMessage(), e);
        return ResponseVO.err(e.getCode(), e.getMessage());
    }

    /**
     * 添加 JSR-303 参数校验返回类型全局异常处理
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh
     * @date 2022/7/28 15:38
     * @since 1.0.0
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO validException(Exception e) {
        BindingResult bindingResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException)e).getBindingResult();
        } else if (e instanceof BindException) {
            bindingResult = ((BindException)e).getBindingResult();
        }
        // 直接从文本重构中读取错误信息
        if (bindingResult != null) {
            StringBuilder validMessage = new StringBuilder();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                String defaultMessage = fieldError.getDefaultMessage();
                if (StringUtils.isBlank(defaultMessage)) {
                    return;
                }
                validMessage.append(paramTypeConvertHandler(defaultMessage, fieldError.getField()));
            });
            log.warn(e.getMessage(), e);
            return new ResponseVO(ResponseCodeEnum.PARAM_IS_ERROR.getCode(),
                    ResponseCodeEnum.PARAM_IS_ERROR.getMsg() + COLON_CHN + validMessage.substring(0,
                            validMessage.length() - 1));
        } else {
            log.warn(e.getMessage(), e);
            return ResponseVO.err(ResponseCodeEnum.PARAM_IS_ERROR.getCode(), e.getMessage());
        }
    }

    /**
     * 参数为空错误(requestParam 不传参数)
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author hyp
     * @date 11:40 2019-08-18
     **/
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        log.warn("BadRequestExceptionHandler -> missingServletRequestParameterExceptionHandler.", e);
        return new ResponseVO(ResponseCodeEnum.PARAM_IS_ERROR.getCode(),
                ResponseCodeEnum.PARAM_IS_ERROR.getMsg() + COLON_CHN + e.getParameterName() + " 不能为空 or null");
    }

    /**
     * 路径错误
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author hyp
     * @date 10:00 2019-08-20
     **/
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO noHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        log.warn("BadRequestExceptionHandler -> noHandlerFoundExceptionHandler.", e);
        return new ResponseVO(ResponseCodeEnum.PATH_ERROR.getCode(), ResponseCodeEnum.PATH_ERROR.getMsg());
    }

    /**
     * 类型不匹配
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author hyp
     * @date 14:50 2019-08-19
     **/
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO httpParamExceptionHandler(TypeMismatchException e) {
        log.warn("BadRequestExceptionHandler -> httpParamExceptionHandler.", e);
        return new ResponseVO(ResponseCodeEnum.PARAM_IS_ERROR.getCode(),
                ResponseCodeEnum.PARAM_IS_ERROR.getMsg() + COLON_CHN + e.getLocalizedMessage(), e.getLocalizedMessage());
    }

    /**
     * <p>Spring Boot controller 层 Get 方式请求使用 @RequestParam 方式接收参数异常捕获，需要在 controller 上添加 @Validated 注解
     * 当前参数给了名称但是值是空的时候走下面这个全局异常捕获器
     * </p>
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh
     * @date 2023/4/13 21:31
     * @since 1.0.2
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO constraintViolationException(ConstraintViolationException e) {
        log.warn(e.getMessage(), e);
        String detailMessage = e.getMessage();
        String[] detailMessageSplit = detailMessage.split(COMMA_ENG);
        StringBuilder validMessage = new StringBuilder();
        for (String message : detailMessageSplit) {
            String[] messageSplit = message.substring(message.lastIndexOf(FULL_STOP_ENG) + 1).split(COLON_ENG);
            if (messageSplit[1].trim().startsWith(messageSplit[0])) {
                validMessage.append(messageSplit[1].trim()).append(COMMA_CHN);
            } else {
                validMessage.append(messageSplit[0].trim()).append(messageSplit[1].trim()).append(COMMA_CHN);
            }
        }
        return ResponseVO.err(ResponseCodeEnum.PARAM_IS_ERROR.getCode(),
                ResponseCodeEnum.PARAM_IS_ERROR.getMsg() + COLON_CHN + validMessage.substring(0,
                        validMessage.length() - 1));
    }

    /**
     * 参数类型不匹配（@RequestParam 类型无法转换）
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author hyp
     * @author juncong.sh
     * @date 14:35 2019-08-31
     * @since 1.0.0
     **/
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO httpParamExceptionHandler(MethodArgumentTypeMismatchException e) {
        log.warn("BadRequestExceptionHandler -> httpParamExceptionHandler.", e);
        String name = e.getName();
        String message = e.getLocalizedMessage();
        String viladMessage = paramTypeConvertHandler(message, name);
        return new ResponseVO(ResponseCodeEnum.PARAM_IS_ERROR.getCode(),
                ResponseCodeEnum.PARAM_IS_ERROR.getMsg() + COLON_CHN +
                        viladMessage.substring(0, viladMessage.length() - 1));
    }

    /**
     * 请求消息无法解析（@RequestBody 解析json失败）
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author hyp
     * @date 14:35 2019-08-31
     **/
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO httpParamExceptionHandler(HttpMessageNotReadableException e) {
        log.warn("BadRequestExceptionHandler -> httpParamExceptionHandler.", e);
        String message = e.getMessage();
        if (StringUtils.isBlank(message)) {
            return new ResponseVO(ResponseCodeEnum.REQUEST_JSON_PARSE_ERROR.getCode(),
                    ResponseCodeEnum.REQUEST_JSON_PARSE_ERROR.getMsg() + COLON_CHN + "未知信息");
        }
        // 处理文本信息
        String typeMessage = message.substring(message.indexOf(CANNOT_DESERIALIZE_VALUE_OF_TYPE));
        // 拿取类型
        String type = typeMessage.substring(typeMessage.indexOf(" `") + 2, typeMessage.indexOf("` "));
        String typeConvert = ParamTypeEnum.TYPE_MAP.get(type).getValue();
        StringBuilder validMessage = new StringBuilder();
        // 拿取字段
        String field = message.substring(message.lastIndexOf("[\"") + 2, message.lastIndexOf("\"]"));
        // 验证是否是 list
        if (message.contains("List")) {
            validMessage.append("List 列表数据中 ").append(field).append(" 类型应该为 ").append(typeConvert);
        } else {
            validMessage.append(field).append(" 类型应该为 ").append(typeConvert);
        }
        return new ResponseVO(ResponseCodeEnum.REQUEST_JSON_PARSE_ERROR.getCode(),
                ResponseCodeEnum.REQUEST_JSON_PARSE_ERROR.getMsg() + COLON_CHN + validMessage);
    }

    /**
     * 不支持的请求方式错误
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author hyp
     * @date 20:21 2019-08-20
     **/
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO httpRequestExceptionHandler(Exception e) {
        log.warn("BadRequestExceptionHandler -> httpRequestExceptionHandler.", e);
        return new ResponseVO(ResponseCodeEnum.HTTP_REQUEST_ERROR.getCode(),
                ResponseCodeEnum.HTTP_REQUEST_ERROR.getMsg() + COLON_CHN + e.getLocalizedMessage());
    }

    /**
     * 不支持的请求头格式
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author hyp
     * @date 20:21 2019-08-20
     **/
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO httpRequestExceptionHandler(HttpMediaTypeNotSupportedException e) {
        log.warn("BadRequestExceptionHandler -> httpRequestExceptionHandler.", e);
        return new ResponseVO(ResponseCodeEnum.HTTP_REQUEST_HEADER_ERROR.getCode(),
                ResponseCodeEnum.HTTP_REQUEST_HEADER_ERROR.getMsg());
    }

    /**
     * 异常处理
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author hyp
     * @date 18:09 2019-08-17
     **/
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseVO runtimeExceptionHandler(Exception e) {
        log.error("BadRequestExceptionHandler -> runtimeExceptionHandler.", e);
        return new ResponseVO(ResponseCodeEnum.SYSTEM_ERROR.getCode(), ResponseCodeEnum.SYSTEM_ERROR.getMsg(),
                String.valueOf(e));
    }

    /**
     * 最大上传文件大小限制异常处理
     *
     * @param e 异常
     * @return {@link ResponseVO} 返回统一数据结构
     * @author juncong.sh@alibaba-inc.com
     * @date 2024/3/6 10:29
     * @since 1.0.7
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseVO maxUploadSizeExceededExceptionHandler(MaxUploadSizeExceededException e) {
        log.warn("BadRequestExceptionHandler -> maxUploadSizeExceededExceptionHandler.", e);
        return new ResponseVO(ResponseCodeEnum.FILE_UPLOAD_ERROR.getCode(),
                ResponseCodeEnum.FILE_UPLOAD_ERROR.getMsg() + COLON_CHN + "文件最大为 " +
                        globalExceptionSpringProperties.getSpringServetMultipartMaxFileSize());
    }

    /**
     * 参数类型转换处理
     *
     * @param message 信息
     * @param field   字段
     * @return 返回拼接好的字符串
     * @author juncong.sh
     * @date 2023/4/14 14:07
     * @since 1.0.2
     */
    private String paramTypeConvertHandler(String message, String field) {
        StringBuilder validMessage = new StringBuilder();
        if (message.startsWith(FAILED_TO_CONVERT_PROPERTY_VALUE_OF_TYPE_PREFIX) ||
                message.startsWith(FAILED_TO_CONVERT_VALUE_OF_TYPE_PREFIX)) {
            String subRequiredType = message.substring(message.indexOf(REQUIRED_TYPE_CHN) + REQUIRED_TYPE_CHN.length());
            String fieldType = subRequiredType.substring(subRequiredType.indexOf("'") + 1,
                    subRequiredType.indexOf("'", 2));
            if (ParamTypeEnum.TYPE_MAP.containsKey(fieldType)) {
                validMessage.append(field).append(" 类型应该为 ")
                        .append(ParamTypeEnum.TYPE_MAP.get(fieldType).getValue()).append(COMMA_CHN);
            } else {
                validMessage.append(field).append(" 类型应该为").append("未知类型").append(COMMA_CHN);
            }
        } else {
            validMessage.append(message).append(COMMA_CHN);
        }
        return validMessage.toString();
    }

}
