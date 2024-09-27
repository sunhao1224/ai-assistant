package com.radiance.ai.assistant.domain.vo.exam;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 考试评论-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstExamCommentVO {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 考试答题表主键 ID
     */
    private Long asstExamAnswerId;
    /**
     * 老师表主键 ID
     */
    private Long asstInfoTeacherId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 分组
     */
    private String group;
    /**
     * 原文
     */
    private String originalText;
    /**
     * 评论
     */
    private String comment;
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
