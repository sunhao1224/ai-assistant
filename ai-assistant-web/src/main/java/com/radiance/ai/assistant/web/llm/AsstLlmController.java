package com.radiance.ai.assistant.web.llm;

import com.radiance.ai.assistant.biz.llm.doubao.DouBaoLlmBiz;
import com.radiance.ai.assistant.domain.dto.llm.PromptGenerateDTO;
import com.radiance.ai.assistant.domain.vo.ResponseVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.annotation.Resource;

/**
 *
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/23 19:53
 * @since 1.0.01
 */
@RestController
@RequestMapping("/asst/llm")
public class AsstLlmController {

    @Resource
    private DouBaoLlmBiz douBaoLlmBiz;

    @PostMapping("/doubao")
    public ResponseVO doubao() {

        // prompt 自训练
        String apiKey = "05e09ecd-10fa-45ac-bd93-9ca25b6e3085";
        ArkService service = ArkService.builder().apiKey(apiKey).baseUrl("https://ark.cn-beijing.volces.com/api/v3/").build();

        System.out.println("\n----- standard request -----");
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("你是豆包，是由字节跳动开发的 AI 人工智能助手").build();
        final ChatMessage userMessage = ChatMessage.builder().role(ChatMessageRole.USER).content("常见的十字花科植物有哪些？").build();
//        final ChatMessage systemMessage = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("- 你是一位专业的语言分析大师，能准确判断两个句子之间核心词的相似度并给出评分和最终得分。当我给出两个句子后，你会迅速分析其中的核心词汇，通过复杂的算法得出相似度评分，评分为100。\n" +
//                "- 如果两个句子的核心词完全不同，你会明确指出差异并给出较低评分；若有一定相似性，你会详细解释相似之处及给出合理评分。打分可以适当放宽\n" +
//                "- 使用json格式返回，相似度评分字段的名称为：score，原因字段的名称为：desc").build();
//        final ChatMessage userMessage = ChatMessage.builder().role(ChatMessageRole.USER).content("给一个专业的prompt").build();
        messages.add(systemMessage);
        messages.add(userMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model("ep-20240922103945-smn9j")
                .messages(messages)
                .build();

        StringBuilder result = new StringBuilder();
        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(choice -> result.append(choice.getMessage().getContent()));


        return ResponseVO.success(result);
    }

    @GetMapping(value = "/stream-model-output", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<StreamingResponseBody> streamModelOutput() {
        // 这里只是一个示例，实际应用中你需要替换为调用大模型API的逻辑
        return getStreamingResponseFromModel();
    }

    private ResponseEntity<StreamingResponseBody> getStreamingResponseFromModel() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_EVENT_STREAM);
        headers.setCacheControl("no-cache");

        StreamingResponseBody responseBody = outputStream -> {
            // 假设callBigModelApiStream是你的方法，它能逐步从大模型获取数据并写入输出流
            callBigModelApiStream(outputStream);
        };

        return ResponseEntity.ok()
                .headers(headers)
                .body(responseBody);
    }

    // 请替换此方法内容以实现实际的大模型API调用逻辑
    private void callBigModelApiStream(OutputStream outputStream) {
        // 示例：逐行写入模拟数据
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for (int i = 0; i < 100; i++) {
                String data = "Streaming data chunk " + i + "\n";
                writer.write(data);
                writer.flush(); // 确保数据立即被发送
                Thread.sleep(100); // 模拟延迟，实际应用中不需要
            }
        } catch (IOException | InterruptedException e) {
            // 处理异常
            e.printStackTrace();
        }
    }

    @GetMapping("/doubao/prompt/generate")
    public ResponseVO doubaoPromptGenerate(@RequestParam(value = "content") String content) {
        return ResponseVO.success(douBaoLlmBiz.promptGenerate(content));
    }

    @PostMapping("/doubao/prompt/generate")
    public ResponseVO doubaoPromptGenerate(@RequestBody PromptGenerateDTO promptGenerateDTO) {
        return ResponseVO.success(douBaoLlmBiz.promptGenerate(promptGenerateDTO.getContent()));
    }

    @GetMapping("/doubao/prompt/generate2")
    public ResponseVO doubaoPromptGenerate2(@RequestParam(value = "content") String content) {
        return ResponseVO.success(douBaoLlmBiz.promptGenerate2(content));
    }


}
