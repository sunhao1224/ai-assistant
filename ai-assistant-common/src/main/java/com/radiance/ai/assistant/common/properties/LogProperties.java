package com.radiance.ai.assistant.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 日志属性类
 *
 * @author juncong.sh
 * @date 2023/6/19 14:48
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "log")
public class LogProperties {

    private Boolean processEnabled = true;

    private String excludeUris = "";

    public Boolean getProcessEnabled() {
        return processEnabled;
    }

    public void setProcessEnabled(Boolean processEnabled) {
        this.processEnabled = processEnabled;
    }

    public String getExcludeUris() {
        return excludeUris;
    }

    public void setExcludeUris(String excludeUris) {
        this.excludeUris = excludeUris;
    }

}
