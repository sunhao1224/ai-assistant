package com.radiance.ai.assistant.common.exception.validation;

import com.radiance.ai.assistant.common.exception.handler.GlobalExceptionHandler;
import com.radiance.ai.assistant.common.exception.runtime.CommonException;
import com.radiance.ai.assistant.domain.enums.ResponseCodeEnum;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 实体列属性验证器
 *
 * @author hyp
 * @author juncong.sh
 * @date 18:04 2019-12-24
 **/
public class BeanValidator {

    public static Validator VALIDATOR;
    public static ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();

    static {
        VALIDATOR = VALIDATOR_FACTORY.getValidator();
    }

    /**
     * 验证某个 bean 的参数约束
     *
     * @param object 验证实体类对象
     * @param groups 分组 Class 对象
     * @author hyp
     * @author juncong.sh
     * @date 18:04 2019-12-24
     * @since 1.0.0
     */
    public static <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = getConstraintViolations(object, groups);
        // 如果有验证信息，则取出来包装成异常返回
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return;
        }
        throw new CommonException(ResponseCodeEnum.PARAM_IS_ERROR, ResponseCodeEnum.PARAM_IS_ERROR.getMsg() +
                GlobalExceptionHandler.COLON_CHN + convertErrorMsg(constraintViolations));
    }

    /**
     * 验证并返回 String 类型错误信息
     *
     * @param object 验证实体类对象
     * @param groups 分组
     * @return 返回错误信息
     * @author juncong.sh
     * @date 2024/1/25 15:22
     * @since 1.0.6
     */
    public static <T> String validateReturnString(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = getConstraintViolations(object, groups);
        // 如果有验证信息，则取出来包装成异常返回
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return "";
        }
        return convertErrorMsg(constraintViolations, "，", 1);
    }

    /**
     * 验证并返回 String 类型错误信息
     *
     * @param object    验证实体类对象
     * @param separator 分隔符
     * @param length    截取长度
     * @param groups    分组
     * @return 返回错误信息
     * @author juncong.sh
     * @date 2024/1/25 15:21
     * @since 1.0.6
     */
    public static <T> String validateReturnString(T object, String separator, Integer length, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = getConstraintViolations(object, groups);
        // 如果有验证信息，则取出来包装成异常返回
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return "";
        }
        return convertErrorMsg(constraintViolations, separator, length);
    }

    /**
     * 验证并返回错误信息列表
     *
     * @param object 验证实体类对象
     * @param groups 分组
     * @return 返回错误信息列表
     * @author juncong.sh
     * @date 2024/1/25 15:24
     * @since 1.0.6
     */
    public static <T> List<String> validateReturnList(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = getConstraintViolations(object, groups);
        // 如果有验证信息，则取出来包装成异常返回
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return Collections.emptyList();
        }
        return convertErrorMsgList(constraintViolations);
    }

    /**
     * 验证bean list
     *
     * @param objectList 待验证对象列表
     * @param groups     分组
     * @author hyp
     * @date 18:04 2019-12-24
     **/
    public static <T> void validate(List<T> objectList, Class<?>... groups) {
        for (T t : objectList) {
            validate(t, groups);
        }
    }

    /**
     * 获取约束验证结果
     *
     * @param object 验证实体类对象
     * @param groups 分组 Class 对象
     * @return 返回约束验证结果
     * @author juncong.sh
     * @date 2024/1/25 14:59
     * @since 1.0.6
     */
    private static <T> Set<ConstraintViolation<T>> getConstraintViolations(T object, Class<?>[] groups) {
        // 获得验证器
        if (null == VALIDATOR) {
            VALIDATOR = VALIDATOR_FACTORY.getValidator();
        }
        // 执行验证
        return VALIDATOR.validate(object, groups);
    }

    /**
     * 转换错误信息
     *
     * @param set 约束验证结果
     * @return 返回错误信息
     * @author juncong.sh
     * @date 2024/1/25 15:08
     * @since 1.0.6
     */
    private static <T> String convertErrorMsg(Set<ConstraintViolation<T>> set) {
        if (CollectionUtils.isEmpty(set)) {
            return "";
        }
        StringBuilder msg = new StringBuilder();
        for (ConstraintViolation<?> data : set) {
            msg.append(data.getMessage());
            msg.append("，");
        }
        return msg.substring(0, msg.length() - 1);
    }

    /**
     * 转换错误信息
     *
     * @param set       约束验证结果
     * @param separator 分隔符
     * @param length    截取长度
     * @return 返回错误信息
     * @author juncong.sh
     * @date 2024/1/25 15:08
     * @since 1.0.6
     */
    private static <T> String convertErrorMsg(Set<ConstraintViolation<T>> set, String separator, Integer length) {
        if (CollectionUtils.isEmpty(set)) {
            return "";
        }
        StringBuilder msg = new StringBuilder();
        for (ConstraintViolation<?> data : set) {
            msg.append(data.getMessage());
            msg.append(separator);
        }
        int cutLength = length == null ? 1 : length;
        return msg.substring(0, msg.length() - cutLength);
    }

    /**
     * 转换错误信息
     *
     * @param set 约束验证结果
     * @return 返回错误信息列表
     * @author juncong.sh
     * @date 2024/1/25 15:18
     * @since 1.0.6
     */
    private static <T> List<String> convertErrorMsgList(Set<ConstraintViolation<T>> set) {
        List<String> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(set)) {
            return list;
        }
        for (ConstraintViolation<?> data : set) {
            list.add(data.getMessage());
        }
        return list;
    }

    /**
     * 拼接异常信息
     *
     * @return java.lang.String
     * @Author hyp
     * @Date 18:04 2019-12-24
     * @Param [set]
     **/
/*    private static <T> String convertErrorMsg(Set<ConstraintViolation<T>> set) {
        Set<ConstraintViolation<?>> sortSet = new TreeSet<>(new Comparator<ConstraintViolation<?>>() {
            @Override
            public int compare(ConstraintViolation o1, ConstraintViolation o2) {
                return o1.getMessage().compareTo(o2.getMessage());
            }
        });
//        Set<ConstraintViolation<T>> sortSet = new TreeSet<>(Comparator.comparing(ConstraintViolation::getMessage));
        sortSet.addAll(set);
        StringBuilder msg = new StringBuilder();
        for (ConstraintViolation<?> data : sortSet) {
            msg.append(data.getMessage());
            msg.append(";");
        }
        return msg.substring(0, msg.length() - 1);
    }*/

}
