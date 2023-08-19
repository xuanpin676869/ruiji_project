package com.xuanpin.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanpin.reggie.dao.ShoppingCartDao;
import com.xuanpin.reggie.pojo.ShoppingCart;
import com.xuanpin.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartDao, ShoppingCart> implements ShoppingCartService {
}
