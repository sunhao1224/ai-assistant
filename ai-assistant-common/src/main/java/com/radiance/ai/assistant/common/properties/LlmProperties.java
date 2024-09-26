package com.radiance.ai.assistant.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * LLM 属性配置类
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 10:22
 * @since 1.0.0
 */
@Data
@Component
public class LlmProperties {

    @Value("${llm.doubao.apiKey}")
    private String douBaoApiKey;

}
