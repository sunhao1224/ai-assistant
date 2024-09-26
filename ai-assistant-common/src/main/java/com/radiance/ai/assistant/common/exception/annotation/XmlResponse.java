package com.radiance.ai.assistant.common.exception.annotation;

import java.lang.annotation.*;

/**
 * Xml 格式返回自定义注解
 *
 * @author juncong.sh
 * @date 2022/7/28 19:19
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XmlResponse {
}
