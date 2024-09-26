package com.radiance.ai.assistant.common.exception.annotation;


import com.radiance.ai.assistant.common.exception.validation.DoubleValueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * double 类型参数校验自定义注解
 *
 * @author juncong.sh
 * @date 2022/7/28 19:17
 * @since 1.0.0
 */
@Documented
@Constraint(validatedBy = {DoubleValueConstraintValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleValue {

    String message() default "值不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    double[] value() default {};

}
