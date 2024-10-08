package com.radiance.ai.assistant.domain.vo.exam;

import lombok.Data;

import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/28 00:41
 * @since
 */
@Data
public class AsstExamAnswerDetailVO {
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
     * 创建人
     */
    private String creator;
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
    /**
     * 评论列表
     */
    private List<AsstExamCommentVO> commentList;
}
