package com.radiance.ai.assistant.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/23 19:53
 * @since 1.0.01
 */
@RestController
@RequestMapping("/ai/assistant")
public class DouBaoController {

    @PostMapping("/doubao")
    public String doubao() {


        return "success";
    }


}
