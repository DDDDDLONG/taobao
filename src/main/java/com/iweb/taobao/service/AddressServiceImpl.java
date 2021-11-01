package com.iweb.taobao.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iweb.taobao.entity.Address;
import com.iweb.taobao.exception.ErrorEnum;
import com.iweb.taobao.mapper.AddressMapper;
import com.iweb.taobao.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public ResponseData save(Address entity) {
        int rows = addressMapper.insert(entity);
        if (rows > 0){
            return new ResponseData(ErrorEnum.SUCCESS);
        }else {
            return new ResponseData(ErrorEnum.ADDRESS_ADD_FAIL);
        }
    }

    @Override
    public ResponseData modify(Address entity) {
        return null;
    }

    @Override
    public ResponseData list(Address entity, Integer current, Integer size) {
        QueryWrapper<Address> qw = new QueryWrapper<>();
        IPage<Address> page = new Page(current,size);

        IPage<Address> addressIPage = addressMapper.selectPage(page, qw);
        return new ResponseData(addressIPage);
    }

    @Override
    public Address view(Integer id) {
        return addressMapper.selectById(id);
    }
}
