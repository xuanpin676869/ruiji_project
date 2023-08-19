package com.xuanpin.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanpin.reggie.dao.OrderDetailDao;
import com.xuanpin.reggie.pojo.OrderDetail;
import com.xuanpin.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailDao, OrderDetail> implements OrderDetailService {
}
