package com.radiance.ai.assistant.common.exception.convert;

import java.lang.annotation.*;

/**
 * 参数驼峰转换自定义注解
 *
 * @author juncong.sh
 * @date 2022/7/8 01:23
 * @since 1.0.0
 */
@Target(value = ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParameterConvert {
}
