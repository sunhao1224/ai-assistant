package com.radiance.ai.assistant.common.exception.validation;


import com.radiance.ai.assistant.common.exception.annotation.IntValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * int 类型验证器
 *
 * @author juncong.sh
 * @date 2022/7/28 20:15
 * @since 1.0.0
 */
public class IntValueConstraintValidator implements ConstraintValidator<IntValue, Integer> {

    private final Set<Integer> set = new HashSet<>();

    /**
     * 初始化方法
     *
     * @param constraintAnnotation 自定义的校验注解
     * @author juncong.sh
     * @date 2022/7/28 20:12
     * @since 1.0.0
     */
    @Override
    public void initialize(IntValue constraintAnnotation) {
        int[] values = constraintAnnotation.value();
        for (int val : values) {
            set.add(val);
        }
    }

    /**
     * 校验
     *
     * @param value   需要校验的值
     * @param context 约束验证器上下文
     * @return {@link Boolean} 验证通过返回 true，否则返回 false
     * @author juncong.sh
     * @date 2022/7/28 20:11
     * @since 1.0.0
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
