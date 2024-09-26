package com.radiance.ai.assistant.domain.enums;

import lombok.Getter;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 20:16
 * @since
 */
@Getter
public enum AsstExamDimensionTypeEnum {
    /**
     * 正常
     */
    COMMON(0),
    ;

    private final Integer value;

    AsstExamDimensionTypeEnum(Integer value) {
        this.value = value;
    }
    }
