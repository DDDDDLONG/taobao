package com.iweb.taobao.service;

import com.iweb.taobao.entity.Brand;
import com.iweb.taobao.exception.ErrorEnum;
import com.iweb.taobao.mapper.BrandMapper;
import com.iweb.taobao.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public ResponseData save(Brand entity) {
        Calendar cal = Calendar.getInstance();
        String gmtModified = String.format("%d-%d-%d %d:%d:%d"
                ,cal.get(Calendar.YEAR),cal.get(Calendar.MARCH)+1,cal.get(Calendar.DAY_OF_MONTH)
                ,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
        entity.setGmtModified(gmtModified);
        entity.setGmtCreate(gmtModified);
        int rows = brandMapper.insert(entity);
        if (rows > 0){
            return new ResponseData(rows);
        }else {
            return new ResponseData(ErrorEnum.BRAND_ADD_FAIL);
        }
    }

    @Override
    public ResponseData modify(Brand entity) {
        return null;
    }

    @Override
    public ResponseData list(Brand entity, Integer current, Integer size) {
        return null;
    }

    @Override
    public Brand view(Integer id) {
        return null;
    }
}
