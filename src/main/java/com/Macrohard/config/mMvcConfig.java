package com.Macrohard.config;

import com.Macrohard.component.loginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//extend configuration of SpringMVC

@Configuration
public class mMvcConfig implements WebMvcConfigurer {

    //all viewController will function together

    @Override
    public void addViewControllers(ViewControllerRegistry registry){

        // direct to certain page when get certain request
        // here success can't get map from helloWorld
        registry.addViewController("/success1").setViewName("success");
        registry.addViewController("/success2").setViewName("success");

        registry.addViewController("/").setViewName("login");
        registry.addViewController("/home").setViewName("login");

        registry.addViewController("/main").setViewName("dashboard");

    }

    //another view controller, but must be registered in container (as bean)
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);

                //this vc provides direct access of html file
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/list.html").setViewName("list");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
                registry.addViewController("/404.html").setViewName("404");
                registry.addViewController("/devLog.html").setViewName("devLog");
                registry.addViewController("/copyright.html").setViewName("copyright");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);

                //OLD VERSION SpringBoot provide static resource(css,js) mapping, won't intercept
                //ADD "/asserts/**" and "/webjars/**" to exclude path to get static resources
                //INTERCEPT any request from any path EXCLUDING request to login page
                registry.addInterceptor(new loginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/asserts/**","/webjars/**","/","/home","/login.html","/user/login","/TEST_query","/druid/*");
            }
        };
        return adapter;
    }
}
