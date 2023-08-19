package com.xuanpin.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanpin.reggie.dto.SetmealDto;
import com.xuanpin.reggie.pojo.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);
}
