package com.radiance.ai.assistant.domain.enums;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 参数类型-enum
 *
 * @author juncong.sh
 * @date 2023/1/16 20:24
 * @since 1.0.1
 */
public enum ParamTypeEnum {

    /**
     * 包装数据类型属性枚举
     */
    BYTE("Byte", "java.lang.Byte"),
    BOOLEAN("Boolean", "java.lang.Boolean"),
    CHARACTER("Character", "java.lang.Character"),
    SHORT("Short", "java.lang.Short"),
    INTEGER("Integer", "java.lang.Integer"),
    FLOAT("Float", "java.lang.Float"),
    LONG("Long", "java.lang.Long"),
    DOUBLE("Double", "java.lang.Double"),
    /**
     * 基础数据类型属性枚举
     */
    BYTE_BASIC("byte", "byte"),
    BOOLEAN_BASIC("boolean", "boolean"),
    CHAR_BASIC("char", "char"),
    SHORT_BASIC("short", "short"),
    INT_BASIC("int", "int"),
    FLOAT_BASIC("float", "float"),
    LONG_BASIC("long", "long"),
    DOUBLE_BASIC("double", "double"),
    ;

    private final String value;

    private final String type;

    public static final Map<String, ParamTypeEnum> TYPE_MAP = Arrays.stream(ParamTypeEnum.values()).collect(
            Collectors.toMap(ParamTypeEnum::getType, e -> e));

    ParamTypeEnum(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public static ParamTypeEnum getValueByType(ParamTypeEnum paramTypeEnum) {
        return Arrays.stream(ParamTypeEnum.values())
                .filter(e -> e.getType().equals(paramTypeEnum.getType()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ResponseCodeEnum.PARAM_TYPE_IS_ERROR.getMsg()));
    }

}
