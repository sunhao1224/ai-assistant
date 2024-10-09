package com.radiance.ai.assistant.domain.vo.exam;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 考试关键词-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstExamKeywordVO {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 考试答题表主键 ID
     */
    private Long asstExamAnswerId;
    /**
     * 学生表主键 ID
     */
    private Long asstInfoStudentId;
    /**
     * 关键词
     */
    private String keyword;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 分组
     */
    private String group;
    /**
     * 创建人
     */
    private String creator;
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
