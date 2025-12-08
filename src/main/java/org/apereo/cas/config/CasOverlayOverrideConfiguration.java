package org.apereo.cas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration
public class CasOverlayOverrideConfiguration {

    /**
     * 自定义视图解析器配置
     * 用于支持标准的CAS登录页面
     */
    @Bean
    public WebMvcConfigurer customWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 使用标准的CAS登录页面而不是自定义页面
                registry.addViewController("/login").setViewName("casLoginView");
            }
        };
    }
}