package com.radiance.ai.assistant.common.exception.runtime;

/**
 * 401 异常处理
 *
 * @author juncong.sh
 * @date 2022/7/28 17:40
 * @since 1.0.0
 */
public class NonAuthorityException extends BaseException {
    public NonAuthorityException() {
    }

    public NonAuthorityException(int code) {
        super(code);
    }

    public NonAuthorityException(String message) {
        super(message);
    }

    public NonAuthorityException(Object data) {
        super(data);
    }

    public NonAuthorityException(int code, String message) {
        super(code, message);
    }

    public NonAuthorityException(int code, String message, Object data) {
        super(code, message, data);
    }

}
