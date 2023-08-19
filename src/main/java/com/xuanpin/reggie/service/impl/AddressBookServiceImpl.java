package com.xuanpin.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanpin.reggie.dao.AddressBookDao;
import com.xuanpin.reggie.pojo.AddressBook;
import com.xuanpin.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookDao, AddressBook> implements AddressBookService {
}
