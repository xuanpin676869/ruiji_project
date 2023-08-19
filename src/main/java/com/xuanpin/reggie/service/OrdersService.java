package com.xuanpin.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanpin.reggie.pojo.Orders;

public interface OrdersService extends IService<Orders> {
    public void submit(Orders orders);
}
