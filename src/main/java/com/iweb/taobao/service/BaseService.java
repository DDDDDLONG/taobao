package com.iweb.taobao.service;

import com.iweb.taobao.response.ResponseData;

/**
 * 基础业务层接口,定义几个公共的方法
 */
public interface BaseService<T> {
    //插入一条数据
    ResponseData save(T entity);
    //修改一条数据，包括逻辑删除
    ResponseData modify(T entity);
    //查询数据
    ResponseData list(T entity, Integer current, Integer size);
    //根据ID查询
    T view(Integer id);
}
