package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 考试答题-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstExamAnswerDetailDTO {
    /**
     * 主键 ID
     */
    @NotNull(message = "id 不能为空")
    private Long id;
}
