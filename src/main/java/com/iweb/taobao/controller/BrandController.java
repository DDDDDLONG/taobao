package com.iweb.taobao.controller;

import com.iweb.taobao.entity.Brand;
import com.iweb.taobao.response.ResponseData;
import com.iweb.taobao.service.BrandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "品牌管理器")
@RequestMapping("/api/brand")
@RestController
public class BrandController implements BaseController<Brand>{
    @Autowired
    private BrandService brandService;
    @Override
    public ResponseData add(Brand entity) {
        return brandService.save(entity);
    }

    @Override
    public ResponseData update(Brand entity) {
        return null;
    }

    @Override
    public ResponseData list(Brand entity, Integer current, Integer size) {
        return null;
    }

    @Override
    public ResponseData view(Integer id) {
        return null;
    }

    @Override
    public ResponseData del(Integer id) {
        return null;
    }
}
