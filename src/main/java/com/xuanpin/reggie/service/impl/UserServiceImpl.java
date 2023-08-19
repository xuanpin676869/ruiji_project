package com.xuanpin.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanpin.reggie.dao.UserDao;
import com.xuanpin.reggie.pojo.User;
import com.xuanpin.reggie.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
