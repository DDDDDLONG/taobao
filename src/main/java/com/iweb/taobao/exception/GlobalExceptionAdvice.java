package com.iweb.taobao.exception;

import com.iweb.taobao.response.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @RestControllerAdvice 这个注解会使IoC容器发现和管理
 * 这个类就称为全局异常处理器类
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
    /**
     * 使用@ExceptionHandler注解方法,括号中取值是某个异常类型的class
     * 表示这个方法可以处理注解括号中指定的异常类型
     * @param e 方法参数e就表示发生的异常对象
     * @return 返回的是响应数据报文对象
     */
    @ExceptionHandler(Exception.class)
    public ResponseData handleException(Exception e){
        ResponseData responseData = new ResponseData(ErrorEnum.SYSTEM_ERROR);
        return responseData;
    }
}
