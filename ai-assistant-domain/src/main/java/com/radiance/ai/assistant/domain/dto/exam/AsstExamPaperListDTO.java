package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 考试试卷-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstExamPaperListDTO {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 考试题库表主键 ID
     */
    private Long asstExamBankId;
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
     * 题目
     */
    private String question;
    /**
     * 答案
     */
    private String answer;
    /**
     * AI 答案
     */
    private String aiAnswer;
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
}
