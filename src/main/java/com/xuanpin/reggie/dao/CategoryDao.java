package com.xuanpin.reggie.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanpin.reggie.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
