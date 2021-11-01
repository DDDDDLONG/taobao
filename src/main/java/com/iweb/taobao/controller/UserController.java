package com.iweb.taobao.controller;

import com.iweb.taobao.entity.User;
import com.iweb.taobao.response.ResponseData;
import com.iweb.taobao.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "用户控制器")
@RestController
@RequestMapping("/api/user")
public class UserController implements BaseController<User> {
    @Autowired
    private UserService userService;
    @Override
    public ResponseData add(User entity) {
        return userService.save(entity);
    }

    @Override
    public ResponseData update(User entity) {
        return new ResponseData(userService.modify(entity));
    }

    @Override
    public ResponseData list(User entity, Integer current,Integer size) {
        return userService.list(entity,current,size);
    }

    @Override
    public ResponseData view(Integer id) {
        return new ResponseData(userService.view(id));
    }

    @Override
    public ResponseData del(Integer id) {
        return null;
    }

    @PostMapping("/login")
    public ResponseData login(User user,HttpServletRequest request, HttpServletResponse response){
        return userService.login(user,request,response);
    }
    @GetMapping("/logout")
    public ResponseData logout(HttpServletRequest request){
        return userService.logout(request);
    }
}
