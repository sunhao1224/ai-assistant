package com.radiance.ai.assistant.domain.vo.exam;

import lombok.Data;

/**
 * 考试维度表
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 13:50
 * @since 1.0.0
 */
@Data
public class AsstExamDimensionVO {
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
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 完成时间
     */
    private String finishTime;
}
