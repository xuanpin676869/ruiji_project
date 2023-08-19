package com.xuanpin.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanpin.reggie.dao.EmployeeDao;
import com.xuanpin.reggie.pojo.Employee;
import com.xuanpin.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements EmployeeService {
}
