package com.Macrohard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//SIGNIFY this is a controller
@Controller
public class controller {

    //SIGNIFY this is a response with body
    //SIGNIFY this response request"hello"
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot!";
    }
}
