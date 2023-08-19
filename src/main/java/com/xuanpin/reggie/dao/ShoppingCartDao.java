package com.xuanpin.reggie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanpin.reggie.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartDao extends BaseMapper<ShoppingCart> {
}
