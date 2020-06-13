package com.Macrohard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
//SIGNIFY this is a controller
@Controller
//ALL RETURN DATA OF METHODS OF THIS CLASS WILL BE SENT TO BROWSER
@ResponseBody
*/

//USE RestController to replace controller+responsebody
@RestController
public class controller {

    //SIGNIFY this is a response with body
    //SIGNIFY this response request"hello"
    //@ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot!";
    }

    //USE RESTAPI TO MAKE YOUR OWN WORK LOGIC
}
