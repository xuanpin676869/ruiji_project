package com.xuanpin.reggie.dto;


import com.xuanpin.reggie.pojo.Dish;
import com.xuanpin.reggie.pojo.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
