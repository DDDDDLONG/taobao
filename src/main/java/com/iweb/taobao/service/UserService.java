package com.iweb.taobao.service;

import com.iweb.taobao.entity.User;
import com.iweb.taobao.response.ResponseData;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Repository
public interface UserService extends BaseService<User>{

    ResponseData login(User user, HttpServletRequest request, HttpServletResponse response);

    ResponseData logout(HttpServletRequest request);
}
