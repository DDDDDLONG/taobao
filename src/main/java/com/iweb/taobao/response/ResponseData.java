package com.iweb.taobao.response;

import com.iweb.taobao.exception.ErrorEnum;
import org.apache.coyote.Response;

/**
 * 封装一个响应数据类
 */
public class ResponseData {
    //错误码
    private String code;
    //错误信息
    private String msg;
    //数据对象
    private Object data;

    //成功的响应报文方法
    public ResponseData(Object data){
        this.data = data;
        this.code = ErrorEnum.SUCCESS.getCode();
        this.msg = ErrorEnum.SUCCESS.getMsg();
    }
    //失败的响应报文方法
    public ResponseData(ErrorEnum error){
        this.data = null;
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
