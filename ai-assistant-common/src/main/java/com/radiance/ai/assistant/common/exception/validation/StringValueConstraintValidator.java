package com.radiance.ai.assistant.common.exception.validation;


import com.radiance.ai.assistant.common.exception.annotation.StringValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * String 类型验证器
 *
 * @author juncong.sh
 * @date 2022/7/28 20:15
 * @since 1.0.0
 */
public class StringValueConstraintValidator implements ConstraintValidator<StringValue, String> {

    private final Set<String> set = new HashSet<>();

    /**
     * 初始化方法
     *
     * @param constraintAnnotation 自定义的校验注解
     * @author juncong.sh
     * @date 2022/7/28 20:00
     * @since 1.0.0
     */
    @Override
    public void initialize(StringValue constraintAnnotation) {
        String[] vals = constraintAnnotation.value();
        set.addAll(Arrays.asList(vals));
    }

    /**
     * 校验
     *
     * @param value   需要校验的值
     * @param context 约束验证器上下文
     * @return {@link Boolean} 验证通过返回 true，否则返回 false
     * @author juncong.sh
     * @date 2022/7/28 20:01
     * @since 1.0.0
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
