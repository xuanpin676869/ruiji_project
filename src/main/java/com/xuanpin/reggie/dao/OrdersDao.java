package com.xuanpin.reggie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanpin.reggie.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersDao extends BaseMapper<Orders> {
}
