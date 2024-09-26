package com.radiance.ai.assistant.domain.enums;

import lombok.Getter;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 20:14
 * @since 1.0.0
 */
@Getter
public enum DataStatusEnum {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 删除
     */
    DELETE(1)
    ;

    private final Integer value;

    DataStatusEnum(Integer value) {
        this.value = value;
    }
}
