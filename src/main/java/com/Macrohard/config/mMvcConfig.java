package com.Macrohard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//extend configuration of SpringMVC

@Configuration
public class mMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){

        // direct to certain page when get certain request
        // here success can't get map from helloWorld
        registry.addViewController("/success1").setViewName("success");
        registry.addViewController("/success2").setViewName("success");
    }
}
