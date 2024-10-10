package com.radiance.ai.assistant.domain.dos.exam;

import lombok.Data;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/10/9 20:49
 * @since
 */
@Data
public class AsstExamAnswerStatisticsLevelDO {
    /**
     * 等级
     */
    private String level;
    /**
     * 统计总数
     */
    private Long count;
}
