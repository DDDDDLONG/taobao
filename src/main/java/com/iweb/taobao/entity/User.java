package com.iweb.taobao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 映射address表
 */
@Data

public class User extends BaseEntity{
    private String username;
    private String password;
    private String realname;
    private String sex;
    private String email;
    private String mobile;
    private String idCode;
    @TableField(exist = false)
    private String token;//密钥

}
