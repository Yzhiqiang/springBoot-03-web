package com.yu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 20:08 2021/9/5
 * @Modified By:
 */
@Configuration
public class MymvcConfig implements WebMvcConfigurer {

//    public interface ViewResolver {     实现了视图解析器接口的类，我们就可以把他看做视图解析器

    //如果我们想扩展SpringMVC，官方建议我们这样去做！
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("index.html").setViewName("index");
        registry.addViewController("main.html").setViewName("dashboard");
    }



    @Bean
    public MyLocalResolver localeResolver()
    {
        return new MyLocalResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**","/emps","/dashboard");
    }


}
