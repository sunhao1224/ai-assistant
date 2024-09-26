package com.radiance.ai.assistant.common.exception.annotation;

import com.radiance.ai.assistant.common.exception.validation.LocationValueConstraintValidator;
import org.springframework.core.annotation.AliasFor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *
 * 坐标类型参数校验自定义注解
 * @author juncong.sh
 * @date 2022/7/29 11:50
 * @since 1.0.0
 */
@Documented
@Constraint(validatedBy = {LocationValueConstraintValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LocationValue {

    String message() default "坐标不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @AliasFor("length")
    int value() default -1;

    @AliasFor("value")
    int length() default -1;

}
