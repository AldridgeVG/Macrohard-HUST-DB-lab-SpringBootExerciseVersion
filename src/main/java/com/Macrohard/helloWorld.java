package com.Macrohard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//SIGNIFY this is a spring boot app
@SpringBootApplication
public class helloWorld {
    public static void main(String[] args) {

        //launch spring boot main app
        SpringApplication.run(helloWorld.class,args);
    }

}
