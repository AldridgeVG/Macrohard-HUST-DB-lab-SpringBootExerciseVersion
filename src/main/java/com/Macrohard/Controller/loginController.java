package com.Macrohard.Controller;

import com.Macrohard.dao.LoginDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class loginController {

    public static boolean inUPList(String musr, String mpwd, List<Map<String,String>> list){

        //test info
        System.out.println("loginusr: "+musr+mpwd);
        System.out.println("usrlist: "+list);

        int size = list.size();
        for(int i=0;i<size;i++){
            Map<String,String> cur = list.get(i);
            if(musr.equals(cur.get("usr")) && mpwd.equals(cur.get("pwd"))) return true;
            else continue;
        }
        return false;
    }

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {

        LoginDao LD = new LoginDao();
        List<Map<String,String>> usersinfo = LD.getAllUsrPwd();

        if (inUPList(username,password,usersinfo)) {

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
