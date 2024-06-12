package io.monodon.sofastack.sofacloud.apigw.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author yaoxiang
 * @description 解决跨域问题
 * @date 2024/6/6 下午6:13
 */
@Deprecated
@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
