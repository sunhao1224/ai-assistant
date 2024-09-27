package com.radiance.ai.assistant.domain.enums;

import lombok.Getter;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 20:14
 * @since 1.0.0
 */
@Getter
public enum TaskStatusEnum {
    /**
     * 未执行
     */
    UN_EXECUTED(0),
    /**
     * 执行中
     */
    EXECUTING(1),
    /**
     * 执行完成
     */
    EXECUTED(2)
    ;

    private final Integer value;

    TaskStatusEnum(Integer value) {
        this.value = value;
    }
}
