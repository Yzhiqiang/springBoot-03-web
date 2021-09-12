package com.yu.config;


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 17:40 2021/9/6
 * @Modified By:
 */
public class MyLocalResolver implements LocaleResolver {
    //解析请求，解析出url
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();     //如果参数中没有携带国际化参数，就是用默认的

        //如果请求的链接携带了国际化的参数
        if(!StringUtils.isEmpty(language))
        {
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
            System.out.println(split[0]+split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
