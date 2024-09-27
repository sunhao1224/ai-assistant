package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;

/**
 *
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 17:45
 * @since 1.0.0
 */
@Data
public class AsstExamDimensionListDTO {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 维度
     */
    private String dimension;
    /**
     * 一级分类
     */
    private String firstClassification;
    /**
     * 二级分类
     */
    private String secondClassification;
    /**
     * 核心字段召回
     */
    private String coreFieldRecall;
}
