package com.xuanpin.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuanpin.reggie.common.CustomException;
import com.xuanpin.reggie.dao.CategoryDao;
import com.xuanpin.reggie.pojo.Category;
import com.xuanpin.reggie.pojo.Dish;
import com.xuanpin.reggie.pojo.Setmeal;
import com.xuanpin.reggie.service.CategoryService;
import com.xuanpin.reggie.service.DishService;
import com.xuanpin.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int countOne = (int) dishService.count(dishLambdaQueryWrapper);

        if(countOne > 0){
            throw new CustomException("当前分类下管关联了菜品，不能删除");
        }

        LambdaQueryWrapper<Setmeal> SetmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        SetmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int countTwo = (int) setmealService.count(SetmealLambdaQueryWrapper);

        if(countTwo > 0){
            throw new CustomException("当前分类下管关联了套餐，不能删除");
        }

        //正常删除分类
        super.removeById(id);
    }
}
