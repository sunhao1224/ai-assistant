package com.radiance.ai.assistant.common.exception.annotation;


import com.radiance.ai.assistant.common.exception.validation.StringValueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * String 类型参数校验自定义注解
 *
 * @author juncong.sh
 * @date 2022/7/28 19:18
 * @since 1.0.0
 */
@Documented
@Constraint(validatedBy = {StringValueConstraintValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringValue {

    String message() default "值不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] value() default {};

}
