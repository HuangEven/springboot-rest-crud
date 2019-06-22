package com.config;

/**
 * @Author: EvenHuang
 * @Date: 2019/6/19 19:54
 */

import com.component.LoginHandlerInterceptor;
import com.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //将组件注册到容器中
    //处理无业务逻辑跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("dashboard");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
        //静态资源：*.css、*.js
        //SpringBoot已经做好了静态资源映射
        //对除“/”以及“/login”以外的请求进行拦截
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login");
        //super.addInterceptors(registry);
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

}