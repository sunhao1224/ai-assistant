package com.radiance.ai.assistant.core.llm.doubao.impl;

import com.radiance.ai.assistant.common.properties.LlmProperties;
import com.radiance.ai.assistant.core.llm.doubao.DouBaoLlm;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 10:26
 * @since 1.0.0
 */
@Component
public class DouBaoLlmImpl implements DouBaoLlm {

    @Resource
    private LlmProperties llmProperties;

    @Override
    public String chat(String systemContent, String userContent) {
        ArkService service = ArkService.builder().apiKey(llmProperties.getDouBaoApiKey())
                .baseUrl("https://ark.cn-beijing.volces.com/api/v3/").build();

        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content(systemContent).build();
        final ChatMessage userMessage = ChatMessage.builder().role(ChatMessageRole.USER).content(userContent).build();
        messages.add(systemMessage);
        messages.add(userMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model("ep-20240922103945-smn9j")
                .messages(messages)
                .build();

        StringBuilder result = new StringBuilder();
        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(choice -> result.append(choice.getMessage().getContent()));

        return result.toString();
    }
}
