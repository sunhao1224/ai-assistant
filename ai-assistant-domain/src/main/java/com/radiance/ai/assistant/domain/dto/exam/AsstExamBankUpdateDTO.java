package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 考试题库-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstExamBankUpdateDTO {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 考试学科主键 ID
     */
    private Long asstExamSubjectId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 名称
     */
    private String name;
    /**
     * 分组
     */
    private String group;
    /**
     * 描述信息
     */
    private String description;
    /**
     * prompt
     */
    private String prompt;
    /**
     * 维度
     */
    private String dimension;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 状态：0-未评估，1-评估中，2-已完成
     */
    private Integer status;
}
