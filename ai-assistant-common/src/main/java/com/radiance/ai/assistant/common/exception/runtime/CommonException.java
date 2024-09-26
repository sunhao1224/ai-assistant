package com.radiance.ai.assistant.common.exception.runtime;

import com.radiance.ai.assistant.domain.enums.ResponseCode;

/**
 * 通用异常
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 16:21
 * @since 1.0.0
 */
public class CommonException extends BaseException {

    public CommonException() {
    }

    public CommonException(Integer code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public CommonException(ResponseCode responseCode) {
        super(responseCode.getCode(), responseCode.getMsg());
    }

    public CommonException(ResponseCode responseCode, String message) {
        super(responseCode.getCode(), message);
    }

}
