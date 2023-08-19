package com.xuanpin.reggie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanpin.reggie.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
