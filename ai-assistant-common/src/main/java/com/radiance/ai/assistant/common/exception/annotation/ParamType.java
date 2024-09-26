package com.radiance.ai.assistant.common.exception.annotation;


import com.radiance.ai.assistant.domain.enums.ParamTypeEnum;

import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 参数类型判断自定义注解
 *
 * @author juncong.sh
 * @date 2023/1/16 17:05
 * @since 1.0.1
 */
@Documented
//@Constraint(validatedBy = {ParamTypeConstraintValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamType {

    String message() default "类型不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ParamTypeEnum value();

}
