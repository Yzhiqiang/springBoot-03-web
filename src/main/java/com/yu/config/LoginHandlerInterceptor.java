package com.yu.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 20:31 2021/9/6
 * @Modified By:
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null)
        {
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else return true;
    }
}
