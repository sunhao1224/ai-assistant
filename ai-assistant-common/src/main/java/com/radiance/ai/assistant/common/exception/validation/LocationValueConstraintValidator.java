package com.radiance.ai.assistant.common.exception.validation;

import com.radiance.ai.assistant.common.exception.annotation.LocationValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 经纬度类型验证器
 *
 * @author juncong.sh
 * @date 2022/7/29 11:49
 * @since 1.0.0
 */
public class LocationValueConstraintValidator implements ConstraintValidator<LocationValue, String> {

    private static final Integer LENGTH = -1;
    private static final Integer MAX = 180;
    private static final Integer MIN = 90;
    private static final Integer COORDINATE_LENGTH = 2;
    private static final String DECIMAL_POINT = "\\.";
    private Boolean checkDecimalPointLength = false;
    private Integer decimalPointLength = -1;

    @Override
    public void initialize(LocationValue constraintAnnotation) {
        this.checkDecimalPointLength = getCheckDecimalPointLength(constraintAnnotation) != LENGTH;
        this.decimalPointLength = constraintAnnotation.length();
    }

    /**
     * 获取注解中小数点长度后几位长度数值
     *
     * @param constraintAnnotation {@link LocationValue} 注解
     * @return 小数点长度后几位长度数值
     * @author juncong.sh
     * @date 2022/7/29 17:41
     * @since 1.0.0
     */
    private int getCheckDecimalPointLength(LocationValue constraintAnnotation) {
        int result = LENGTH;
        if (constraintAnnotation.value() != LENGTH) {
            result = constraintAnnotation.value();
        }
        if (constraintAnnotation.length() != LENGTH) {
            result = constraintAnnotation.length();
        }
        return result;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return checkLocation(value);
    }

    /**
     * @param location 经纬度坐标
     * @return 返回校验结果：true-通过，false-不通过
     * @author juncong.sh
     * @date 2022/7/29 16:11
     * @since 1.0.0
     */
    private boolean checkLocation(String location) {
        String[] coordinate = location.split(",");
        if (coordinate.length != COORDINATE_LENGTH) {
            return false;
        }
        double x, y;
        try {
            x = Double.parseDouble(coordinate[0]);
            y = Double.parseDouble(coordinate[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        if (x < -MAX || x > MAX || y < -MIN || y > MIN) {
            return false;
        }
        // 经纬度小数点后几位长度校验
        if (checkDecimalPointLength) {
            try {
                if (coordinate[0].split(DECIMAL_POINT)[1].length() != decimalPointLength) {
                    return false;
                }
                if (coordinate[1].split(DECIMAL_POINT)[1].length() != decimalPointLength) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

}
