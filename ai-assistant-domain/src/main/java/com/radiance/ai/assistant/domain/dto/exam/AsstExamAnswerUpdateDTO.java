package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 考试答题-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstExamAnswerUpdateDTO {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 考试试卷表主键 ID
     */
    private Long asstExamPaperId;
    /**
     * 老师表主键 ID
     */
    private Long asstInfoStudentId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 分组
     */
    private String group;
    /**
     * 题目
     */
    private String question;
    /**
     * 答案
     */
    private String answer;
    /**
     * 得分
     */
    private Integer score;
    /**
     * AI 预测得分
     */
    private Integer aiScore;
    /**
     * 命中点
     */
    private Integer hitPoint;
    /**
     * 命中掩码
     */
    private String hitMask;
    /**
     * AI 标签
     */
    private String aiTag;
    /**
     * AI 结果
     */
    private String aiResult;
    /**
     * AI 总结要点
     */
    private String aiSummary;
    /**
     * 创建人
     */
    private String creator;
}
