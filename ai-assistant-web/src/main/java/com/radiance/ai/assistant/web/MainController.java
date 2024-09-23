package com.radiance.ai.assistant.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Mvc的根路径、健康检查等。
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/23 17:48
 * @since 1.0.0
 */
@RestController
public class MainController {

    @GetMapping("/check/preload")
    public String checkPreload() {
        return "success";
    }

}
