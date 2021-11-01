package com.iweb.taobao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iweb.taobao.entity.Address;
import com.iweb.taobao.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper extends BaseMapper<Comment> {
}
