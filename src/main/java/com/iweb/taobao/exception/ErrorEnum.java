package com.iweb.taobao.exception;

public enum ErrorEnum {
    //在第一行处必须将所有错误信息对象枚举出来即可,修饰符 public static final
    //对象用','链接,';'结束枚举
    SUCCESS("00000","一切OK"),
    ACCOUNT_VALID_FAIL("A0110","用户名校验失败"),
    ACCOUNT_EXISTS("A0111","用户名已存在"),
    PASSWORD_VALID_FAIL("A0120","密码校验失败"),
    AUTH_VAILD_FAIL("A0220","用户身份校验失败"),
    SYSTEM_ERROR("B0001","系统执行出错"),
    ADDRESS_ADD_FAIL("A0110","地址添加失败"),
    DATA_NOT_FOUND("A0404","数据不存在"),
    BRAND_ADD_FAIL("A0110","品牌添加失败");

    //错误码
    private String code;
    //错误信息
    private String msg;

    ErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
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


}
