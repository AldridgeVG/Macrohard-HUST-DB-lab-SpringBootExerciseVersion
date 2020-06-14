package com.Macrohard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {
    //    @GetMapping
    //    @DeleteMapping
    //    @PutMapping
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && password.equals("123456")) {

            //SAVE loged in user in session, send to
            session.setAttribute("loginUser", username);

            //REDIRECT to dashboard (mvc config main <==> dashboard.html),
            //GOAL: prevent repeated submit of form
            //return "dashboard";
            return "redirect:/main";
        } else {
            map.put("msg", "WRONG username OR password");
            //RETURN to login page
            return "login";
        }
    }
}
