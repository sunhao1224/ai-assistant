package com.radiance.ai.assistant.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局捕获异常配置属性类
 *
 * @author juncong.sh
 * @date 2022/7/27 19:29
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "catch.exception")
@Component
@Data
public class GlobalExceptionProperties {

    private boolean enabled = true;

}
