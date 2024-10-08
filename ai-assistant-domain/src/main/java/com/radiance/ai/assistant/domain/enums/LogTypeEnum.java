package com.radiance.ai.assistant.domain.enums;

/**
 * 日志类型枚举类
 *
 * @author juncong.sh
 * @date 2023/6/19 21:27
 * @since 1.0.0
 */
public enum LogTypeEnum {
    /**
     * 流程日志
     */
    PROCESS("Process log"),
    ;

    private final String value;

    LogTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
