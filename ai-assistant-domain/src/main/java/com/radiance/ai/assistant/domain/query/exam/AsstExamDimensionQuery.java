package com.radiance.ai.assistant.domain.query.exam;

import lombok.Builder;
import lombok.Data;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 15:54
 * @since 1.0.0
 */
@Data
@Builder
public class AsstExamDimensionQuery {
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
    /**
     * 数据状态：0-未删除，1-已删除
     */
    private Integer dataStatus;
}
