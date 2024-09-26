package com.radiance.ai.assistant.common.exception.convert;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 参数 Web 配置类
 *
 * @author juncong.sh
 * @date 2022/7/8 01:33
 * @since 1.0.0
 */
public class ParamWebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ConvertArgumentResolver());
    }

}
