package com.radiance.ai.assistant.domain.dto.llm;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/28 10:35
 * @since
 */
@Data
public class PromptGenerateDTO {

    @NotNull(message = "content 不能为空")
    private String content;

}
