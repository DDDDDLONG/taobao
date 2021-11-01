package com.iweb.taobao.exception;

/**
 * 自定义异常,继承RuntimeException异常
 */
public class CustomException extends RuntimeException{
    private ErrorEnum errorEnum;

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    public CustomException(ErrorEnum errorEnum) {
        super(errorEnum.getMsg());//将错误信息传给父类
        this.errorEnum = errorEnum;
    }
}
