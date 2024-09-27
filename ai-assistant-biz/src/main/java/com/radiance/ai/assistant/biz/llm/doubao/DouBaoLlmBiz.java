package com.radiance.ai.assistant.biz.llm.doubao;

/**
 * 字节跳动-豆包-LLM 业务接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 10:57
 * @since 1.0.0
 */
public interface DouBaoLlmBiz {

    String promptGenerate(String content);

    String aiAssist(String content);

}
