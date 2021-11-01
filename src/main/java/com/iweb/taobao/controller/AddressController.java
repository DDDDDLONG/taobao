package com.iweb.taobao.controller;

import com.iweb.taobao.entity.Address;
import com.iweb.taobao.response.ResponseData;
import com.iweb.taobao.service.AddressService;
import com.iweb.taobao.service.AddressServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户地址控制器")
@RequestMapping("/api/address")
public class AddressController implements BaseController<Address>{
    @Autowired
    private AddressService addressService;
    @Override
    public ResponseData add(Address entity) {
        return addressService.save(entity);
    }

    @Override
    public ResponseData update(Address entity) {
        return null;
    }

    @Override
    public ResponseData list(Address entity, Integer current, Integer size) {
        return addressService.list(entity,current,size);
    }

    @Override
    public ResponseData view(Integer id) {
        return new ResponseData(addressService.view(id));
    }

    @Override
    public ResponseData del(Integer id) {
        return null;
    }
}
