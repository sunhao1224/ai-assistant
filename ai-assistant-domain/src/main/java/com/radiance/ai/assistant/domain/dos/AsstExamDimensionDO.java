package com.radiance.ai.assistant.domain.dos;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 考试维度表
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 13:50
 * @since 1.0.0
 */
@Data
public class AsstExamDimensionDO {
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
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 完成时间
     */
    private LocalDateTime finishTime;
}
