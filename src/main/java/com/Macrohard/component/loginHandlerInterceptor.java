package com.Macrohard.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//check login status
public class loginHandlerInterceptor implements HandlerInterceptor {

    //before the exe of obj method, pre check
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null) {
            System.out.println("UNAUTHORIZED! PLZ LOGIN");
            //not loged in, intercept
            request.setAttribute("msg","UNAUTHORIZED! Please log in");
            request.getRequestDispatcher("/home").forward(request,response);
            return false;
        }else{

            //loged in, let pass
            return true;
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
