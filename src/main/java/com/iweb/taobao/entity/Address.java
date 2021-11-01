package com.iweb.taobao.entity;

import lombok.Data;

/**
 * 映射address表
 */
@Data
public class Address extends BaseEntity{
    private long userId;
    private String province;
    private String city;
    private String district;
    private String detail;
    private Integer remark;
    private Integer isDefault;
}
