package com.xuanpin.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanpin.reggie.dao.DishFlavorDao;
import com.xuanpin.reggie.pojo.DishFlavor;
import com.xuanpin.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorDao, DishFlavor> implements DishFlavorService {
}
