package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/10/9 20:18
 * @since
 */
@Data
public class AsstExamKeywordStatisticsDTO {
    /**
     * 考试题库表主键 ID
     */
    @NotNull(message = "asstExamBankId 不能为空")
    private Long asstExamBankId;

}
