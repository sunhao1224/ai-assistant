package com.radiance.ai.assistant.common.exception.runtime;

/**
 * 500 异常处理
 *
 * @author juncong.sh
 * @date 2022/7/28 17:57
 * @since 1.0.0
 */
public class HttpResponseException extends BaseException {
    public HttpResponseException() {
    }

    public HttpResponseException(int code) {
        super(code);
    }

    public HttpResponseException(String message) {
        super(message);
    }

    public HttpResponseException(Object data) {
        super(data);
    }

    public HttpResponseException(int code, String message) {
        super(code, message);
    }

    public HttpResponseException(int code, String message, Object data) {
        super(code, message, data);
    }
}
