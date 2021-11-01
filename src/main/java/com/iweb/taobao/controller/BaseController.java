package com.iweb.taobao.controller;

import com.iweb.taobao.response.ResponseData;
import org.springframework.web.bind.annotation.*;

public interface BaseController<T> {
    @PostMapping("/add")
    ResponseData add(T entity);
    @PostMapping("/update")
    ResponseData update(T entity);
    @GetMapping("/list")
    ResponseData list(T entity,Integer current,Integer size);
    @GetMapping("/view/{id}")
    ResponseData view(@PathVariable("id") Integer id);
    @DeleteMapping("/del/{id}")
    ResponseData del(@PathVariable("id") Integer id);
}
