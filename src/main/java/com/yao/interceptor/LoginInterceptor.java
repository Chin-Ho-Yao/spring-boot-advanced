package com.yao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jack Yao on 2021/6/16 9:48 下午
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        /*請求拿到session在拿到user如果為空就不讓他繼續往下調用*/
        if (request.getSession().getAttribute("user") == null){
            /*讓他返回登錄頁面*/
            response.sendRedirect("/login");

            return false;
        }
        return true;
    }
}
