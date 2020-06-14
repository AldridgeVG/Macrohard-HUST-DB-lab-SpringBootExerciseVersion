package com.Macrohard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/*
//SIGNIFY this is a controller
@Controller
//ALL RETURN DATA OF METHODS OF THIS CLASS WILL BE SENT TO BROWSER
@ResponseBody
*/

//USE RestController to replace controller+responsebody
@Controller
public class controller {

    //SIGNIFY this is a response with body
    //SIGNIFY this response request"hello"
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot!";
    }

    /*
    //NEW IMPLEMENT to view controller

    @RequestMapping({"/","/login","/home","/login.html"})
    public String login(){

        //look for login.html in templates/
        return "login";
    }
    */


    //test
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        /*
        * according to thymeleaf:
        * public static final String DEFAULT_PREFIX = "classpath:/templates/";
	    * public static final String DEFAULT_SUFFIX = ".html";
        *
        * ==> find file in "resources/templates/success.html"
        * ==> html get map's value by thymeleaf grammar
        * */

        map.put("Key1","<h2>Value1</h2>");
        map.put("MASTER","Aldridge von Galland");
        map.put("GUESTS", Arrays.asList("Tina","Cinder","Vincent","Anthea"));

        return "success";
    }
}
