package com.iweb.taobao.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iweb.taobao.entity.User;
import com.iweb.taobao.exception.CustomException;
import com.iweb.taobao.exception.ErrorEnum;
import com.iweb.taobao.mapper.UserMapper;
import com.iweb.taobao.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseData save(User entity) {
        Calendar cal = Calendar.getInstance();
        String gmtModified = String.format("%d-%d-%d %d:%d:%d"
                ,cal.get(Calendar.YEAR),cal.get(Calendar.MARCH)+1,cal.get(Calendar.DAY_OF_MONTH)
                ,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
        entity.setGmtModified(gmtModified);
        entity.setGmtCreate(gmtModified);
        int rows = userMapper.insert(entity);
        if (rows>0){
            return new ResponseData(ErrorEnum.SUCCESS);
        }else {
            throw new CustomException(ErrorEnum.ACCOUNT_VALID_FAIL);
        }
    }

    @Override
    public ResponseData modify(User entity) {
        Calendar cal = Calendar.getInstance();
        String gmtModified = String.format("%d-%d-%d %d:%d:%d"
                ,cal.get(Calendar.YEAR),cal.get(Calendar.MARCH)+1,cal.get(Calendar.DAY_OF_MONTH)
                ,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
        entity.setGmtModified(gmtModified);
        int rows = userMapper.updateById(entity);
        if(rows<1){
            throw new CustomException(ErrorEnum.SYSTEM_ERROR);
        }
        return new ResponseData(rows);
    }



    @Override
    public ResponseData list(User entity, Integer current, Integer size) {
        IPage<User> page = new Page<>(current,size);
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like(!StringUtils.isEmpty(entity.getUsername()),"username",entity.getUsername());
        qw.eq(!StringUtils.isEmpty(entity.getSex()),"sex",entity.getSex());
        qw.eq(!StringUtils.isEmpty(entity.getIsDelete()),"is_delete",entity.getIsDelete());

        IPage<User> selectPage = userMapper.selectPage(page, qw);
        return new ResponseData(selectPage);
    }

    @Override
    public User view(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public ResponseData login(User user, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq(user.getUsername() != null, "username", user.getUsername());
        User user1 = userMapper.selectOne(userQueryWrapper);
        ResponseData responseData = null;
        request.getSession().removeAttribute("tmallKey");
        if (user1 != null) {
            if (user.getPassword().equals(user1.getPassword())) {
                //生成密钥
                String token = UUID.randomUUID().toString().replace("-", "");
                //密钥放入user对象中
                user1.setToken(token);
                //密钥放入session中
                request.getSession().setAttribute("tmallKey", token);
                //密钥放到cookie中
                Cookie cookie = new Cookie("token", token);
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);
                //把user对象放入响应报文中
                responseData = new ResponseData(user1);
                return responseData;
            } else {
                responseData = new ResponseData(ErrorEnum.PASSWORD_VALID_FAIL);
                return responseData;
            }
        } else {
            responseData = new ResponseData(ErrorEnum.ACCOUNT_VALID_FAIL);
            return responseData;
        }
    }

    @Override
    public ResponseData logout(HttpServletRequest request) {
        request.getSession().removeAttribute("tmallKey");
        ResponseData responseData = new ResponseData(ErrorEnum.SUCCESS);
        return responseData;
    }
}
