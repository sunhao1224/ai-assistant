package com.radiance.ai.assistant.core.llm.doubao;

/**
 * 字节跳动-豆包 LLM
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 10:25
 * @since 1.0.0
 */
public interface DouBaoLlm {

    String chat(String systemContent, String userContent);

}
