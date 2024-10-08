package com.radiance.ai.assistant.common.config;

import com.radiance.ai.assistant.common.log.filter.GlobalProcessLogFilter;
import com.radiance.ai.assistant.common.properties.LogProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/10/8 13:56
 * @since
 */
@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class GlobalLogConfig {

    @Bean
    @ConditionalOnMissingBean(LogInterceptorConfig.class)
    public LogInterceptorConfig logInterceptorConfig() {
        return new LogInterceptorConfig();
    }

    @Bean
    @ConditionalOnProperty(value = "log.process-enabled", matchIfMissing = true, havingValue = "true")
    public FilterRegistrationBean<GlobalProcessLogFilter> globalProcessLogFilter(LogProperties logProperties) {
        FilterRegistrationBean<GlobalProcessLogFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setName("globalProcessLogFilter");
        filterRegistrationBean.setFilter(new GlobalProcessLogFilter(logProperties));
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        return filterRegistrationBean;
    }

}
