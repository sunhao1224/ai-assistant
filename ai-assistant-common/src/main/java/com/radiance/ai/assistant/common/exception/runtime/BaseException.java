package com.radiance.ai.assistant.common.exception.runtime;


import com.radiance.ai.assistant.domain.enums.ResponseCode;
import com.radiance.ai.assistant.domain.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;

/**
 * 基础异常类，提供基础字段功能-不建议实例化
 *
 * @author juncong.sh
 * @date 2022/7/28 17:29
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends RuntimeException {

    private int code = ResponseCodeEnum.SYSTEM_ERROR.getCode();
    private String message = ResponseCodeEnum.SYSTEM_ERROR.getMsg();
    private Object data = null;

    public BaseException(Integer code) {
        this.code = code;
    }

    public BaseException(String message) {
        this.message = message;
    }

    public BaseException(Object data) {
        this.data = data;
    }

    public BaseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(ResponseCode responseCode, Throwable throwable) {
        super(responseCode.getMsg(), throwable);
        this.code = responseCode.getCode();
        this.message = responseCode.getMsg();
    }

    public BaseException(ResponseCode responseCode, String... args) {
        super(MessageFormat.format(responseCode.getMsg(), (Object)args));
        this.code = responseCode.getCode();
        this.message = responseCode.getMsg();
    }

}
