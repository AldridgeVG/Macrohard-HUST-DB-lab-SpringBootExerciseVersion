package com.Macrohard.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //add to container by @Bean
    //bind all config start with "spring.ds"
    //return a datasource
    //IMPORT log4j jar pack in pom.xml
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //config druid monitor
    //1. a servlet that manage backstage,deal with all request from /druid
    //2. a filter for monitoring
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new StatViewServlet(),"/druid/*");

        //set init param
        Map<String,String> initParams = new HashMap<>();

        //backstage manager usr/pwd
        initParams.put("loginUsername","root");
        initParams.put("loginPassword","galland990531");

        //allowed usrs("" means everyone)
        initParams.put("allow","");

        //denied usrs
        initParams.put("deny","192.118.9.9");

        //set param and return this bean
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //set init param
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,*.svg,/druid/*");

        bean.setInitParameters(initParams);

        //set requests that will be intercepted by filter
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
