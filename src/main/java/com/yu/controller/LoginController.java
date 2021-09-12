package com.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 19:57 2021/9/6
 * @Modified By:
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session)
    {
        if(!StringUtils.isEmpty(username) && "111".equals(password))
        {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else
        {
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index";
    }
}
