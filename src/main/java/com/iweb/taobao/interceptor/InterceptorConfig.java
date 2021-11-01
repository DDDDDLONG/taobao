package com.iweb.taobao.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建的拦截器类创建一个拦截器对象
        AuthInterceptor authInterceptor = new AuthInterceptor();
        //registry对象代表拦截器注册表
        registry.addInterceptor(authInterceptor)
                //拦截谁
        .addPathPatterns("/api/*")
                .addPathPatterns("/*.html")
                //放行谁
        .excludePathPatterns("/api/user/login")
        .excludePathPatterns("/l ogin.html");
    }
}
