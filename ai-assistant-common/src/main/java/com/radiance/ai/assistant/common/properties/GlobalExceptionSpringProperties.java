package com.radiance.ai.assistant.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局异常 Spring 配置属性
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/3/6 10:48
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "spring")
@Component
public class GlobalExceptionSpringProperties {

    @Value("${spring.servlet.multipart.max-file-size:1MB}")
    public String springServetMultipartMaxFileSize;

    public String getSpringServetMultipartMaxFileSize() {
        return springServetMultipartMaxFileSize;
    }

}
