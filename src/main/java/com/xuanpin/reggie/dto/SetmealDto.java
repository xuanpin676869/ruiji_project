package com.xuanpin.reggie.dto;


import com.xuanpin.reggie.pojo.Setmeal;
import com.xuanpin.reggie.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
