package com.xuanpin.reggie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanpin.reggie.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
}
