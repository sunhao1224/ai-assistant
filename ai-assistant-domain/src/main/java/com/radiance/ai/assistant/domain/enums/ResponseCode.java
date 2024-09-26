package com.radiance.ai.assistant.domain.enums;

/**
 * 错误枚举接口
 * <p> 用途：用于各个项目引入该模块，然后实现该接口，定义自己项目的错误码，
 * 然后使用{@link com.radiance.ai.assistant.common.exception.runtime.CommonException}</p>
 *
 * @author tanguohua.tgh
 * @date 2021/10/20
 */
public interface ResponseCode {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    Integer getCode();

    /**
     * 获取错误消息
     *
     * @return 错误消息
     */
    String getMsg();

}
