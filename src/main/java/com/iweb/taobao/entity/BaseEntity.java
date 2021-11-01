package com.iweb.taobao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 所有实体类的父类,封装所有实体类共同的属性
 */
@Data
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(fill = FieldFill.INSERT)
    private String gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String gmtModified;
    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }
}
