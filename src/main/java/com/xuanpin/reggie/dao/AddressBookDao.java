package com.xuanpin.reggie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuanpin.reggie.pojo.AddressBook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressBookDao extends BaseMapper<AddressBook> {
}
