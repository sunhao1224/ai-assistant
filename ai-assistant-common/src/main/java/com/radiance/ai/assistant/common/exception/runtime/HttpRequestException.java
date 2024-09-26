package com.radiance.ai.assistant.common.exception.runtime;

/**
 * 400 异常处理
 *
 * @author juncong.sh
 * @date 2022/7/28 17:33
 * @since 1.0.0
 */
public class HttpRequestException extends BaseException {
    public HttpRequestException() {
    }

    public HttpRequestException(int code) {
        super(code);
    }

    public HttpRequestException(String message) {
        super(message);
    }

    public HttpRequestException(Object data) {
        super(data);
    }

    public HttpRequestException(int code, String message) {
        super(code, message);
    }

    public HttpRequestException(int code, String message, Object data) {
        super(code, message, data);
    }
}
