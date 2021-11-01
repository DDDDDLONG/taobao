package com.iweb.taobao.service;

import com.iweb.taobao.entity.Category;
import com.iweb.taobao.response.ResponseData;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements BaseService<Category>{
    @Override
    public ResponseData save(Category entity) {
        return null;
    }

    @Override
    public ResponseData modify(Category entity) {
        return null;
    }

    @Override
    public ResponseData list(Category entity, Integer current, Integer size) {
        return null;
    }

    @Override
    public Category view(Integer id) {
        return null;
    }
}
