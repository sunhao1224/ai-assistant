package com.radiance.ai.assistant.common.exception.convert;

import java.lang.annotation.*;

/**
 * 自定义实体列参数属性注解
 *
 * @author juncong.sh
 * @date 2022/7/12 23:55
 * @since 1.0.0
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamProperty {
    /**
     * 自定义字段接收值
     */
    String value();
}
