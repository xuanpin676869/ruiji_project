package com.xuanpin.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanpin.reggie.common.CustomException;
import com.xuanpin.reggie.dao.SetmealDao;
import com.xuanpin.reggie.dto.SetmealDto;
import com.xuanpin.reggie.pojo.Setmeal;
import com.xuanpin.reggie.pojo.SetmealDish;
import com.xuanpin.reggie.service.SetmealDishService;
import com.xuanpin.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealDao, Setmeal> implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 新增套餐，更新setmeal,setmeal_dish两张表
     * @param setmealDto
     */
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐基本信息
        this.save(setmealDto);

        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item) -> {
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());

        //保存套餐和菜品的关联信息
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 删除套餐，套餐已起售则不能删除，也是删除两张表的内容
     * @param ids
     */

    @Transactional
    public void removeWithDish(List<Long> ids) {
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);

        int count = (int) this.count(queryWrapper);
        if(count > 0){
            //存在未停售的套餐
            throw new CustomException("套餐正在售卖中，不能删除");
        }

        //删除setmeal表里对应数据
        this.removeByIds(ids);
        //删除setmeal_dish表对应数据
        LambdaQueryWrapper<SetmealDish> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(queryWrapper1);
    }
}
