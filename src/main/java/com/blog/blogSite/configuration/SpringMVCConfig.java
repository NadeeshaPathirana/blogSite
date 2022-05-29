package com.blog.blogSite.configuration;

import com.blog.blogSite.service.authservice.interceptor.ApplicationLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    ApplicationLoginInterceptor applicationLoginInterceptor;

    /**
     * Add Spring MVC lifecycle interceptors for pre-processing of controller method invocations
     */
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(applicationLoginInterceptor);
    }

}


