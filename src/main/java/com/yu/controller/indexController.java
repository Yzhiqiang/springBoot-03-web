package com.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 16:39 2021/9/6
 * @Modified By:
 */
@Controller
public class indexController {
    @RequestMapping({"/","/index.html"})
    public String index()
    {
        return "index";
    }
}
