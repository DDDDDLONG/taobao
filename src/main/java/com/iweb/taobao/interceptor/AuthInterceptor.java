package com.iweb.taobao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())){
                    if (request.getSession() != null &&
                            cookie.getValue() != null &&
                            cookie.getValue().equals(request.getSession().getAttribute("tmallKey"))){
                        return true;
                    }else {
                        break;
                    }
                }
            }
        }
        response.sendRedirect("/login.html");
        return false;
    }
}
