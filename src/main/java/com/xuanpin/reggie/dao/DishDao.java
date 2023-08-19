package com.xuanpin.reggie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanpin.reggie.pojo.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishDao extends BaseMapper<Dish> {
}
