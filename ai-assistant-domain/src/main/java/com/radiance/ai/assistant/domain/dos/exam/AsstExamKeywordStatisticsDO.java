package com.radiance.ai.assistant.domain.dos.exam;

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
public class AsstExamKeywordStatisticsDO {
    /**
     * 关键词
     */
    private String keyword;
    /**
     * 统计总数
     */
    private Long count;
}
