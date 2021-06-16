package com.yao.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Jack Yao on 2021/6/16 9:53 下午
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /*增加攔截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*addPathPatterns添加要攔截的地址，斜線代表攔截首頁面*/
        /*星號代表攔截books為首的頁面*/
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/")
                .addPathPatterns("/books/**");

    }
}
