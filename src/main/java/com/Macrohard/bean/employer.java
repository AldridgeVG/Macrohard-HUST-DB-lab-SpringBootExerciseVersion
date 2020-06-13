package com.Macrohard.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/*
* dynamic bind conf(every k-value) in properties file to a component
* prefix signifys which set of config will bind
* bind target must be a component by @Component
* */
@Component
@ConfigurationProperties(prefix = "employer")
public class employer {
    private String name;
    private Integer age;
    private Map<String, Object> map;
    private List<Object> list;
    private Set<Object> set;
}
