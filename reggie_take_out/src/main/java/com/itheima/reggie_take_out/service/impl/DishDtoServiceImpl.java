package com.itheima.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.entity.Category;
import com.itheima.reggie_take_out.entity.Dish;
import com.itheima.reggie_take_out.dto.DishDto;
import com.itheima.reggie_take_out.entity.DishFlavor;
import com.itheima.reggie_take_out.service.CategoryService;
import com.itheima.reggie_take_out.service.DishDtoService;
import com.itheima.reggie_take_out.service.DishFlavorService;
import com.itheima.reggie_take_out.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UMP90
 * @date 2021/10/15
 */
@Service
@Slf4j
public class DishDtoServiceImpl implements DishDtoService {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public CommonReturn<?> save(DishDto dishDto) {
        dishService.save(dishDto);
        return CommonReturn.success("Add dish success");
    }

    @Override
    @Transactional
    public CommonReturn<?> saveWithFlavor(DishDto dishDto) {
        this.save(dishDto);
        Long id = dishDto.getId();

        List<DishFlavor> dishFlavors = dishDto.getFlavors();
        dishFlavors.forEach(s -> {
            s.setDishId(id);
        });
        if (dishFlavorService.saveBatch(dishFlavors)) {
            return CommonReturn.success("Add dish with flavors success");
        } else {
            return CommonReturn.error("Fail to add dish with flavors");
        }

    }

    @Override
    @Transactional
    public CommonReturn<?> list(Integer page, Integer pageSize, String name) {
        Page<Dish> dishPage = new Page<>(page, pageSize);
        Page<DishDto> dishDtoPage = new Page<>();
        LambdaQueryWrapper<Dish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.hasLength(name), Dish::getName, name).orderByDesc(Dish::getUpdateTime);
        dishService.page(dishPage, lambdaQueryWrapper);
        BeanUtils.copyProperties(dishPage, dishDtoPage, "records");
        List<Dish> list = dishPage.getRecords();

        List<DishDto> dishDtoList = new ArrayList<>();

        list.forEach(dish -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(dish, dishDto);
            Long categoryId = dishService.getById(dish.getId()).getCategoryId();
            String categoryName = categoryService.getById(categoryId).getName();
            if (categoryName != null) {
                dishDto.setCategoryName(categoryName);
            }
            dishDtoList.add(dishDto);
        });
        dishDtoPage.setRecords(dishDtoList);
        return CommonReturn.success(dishDtoPage);

    }

    @Override
    public CommonReturn<?> getByIdWithFlavor(Long id) {
        Dish dish = dishService.getById(id);
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(lambdaQueryWrapper);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish, dishDto);
        dishDto.setFlavors(flavors);
        return CommonReturn.success(dishDto);
    }

    @Transactional
    @Override
    public CommonReturn<?> updateWithFlavors(DishDto dishDto) {
        dishService.updateById(dishDto);
        Long dishId = dishDto.getId();
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(DishFlavor::getDishId, dishId);
        dishFlavorService.remove(lambdaQueryWrapper);
        List<DishFlavor> flavorList = dishDto.getFlavors();
        flavorList.forEach(
                dishFlavor -> {
                    dishFlavor.setDishId(dishId);
                    dishFlavor.setId(null);
                    dishFlavorService.save(dishFlavor);
                }
        );

        return CommonReturn.success("Update dish success");

    }

    @Override
    public CommonReturn<?> getByCategoryId(Long categoryId, Integer status) {
        LambdaQueryWrapper<Dish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(categoryId != null, Dish::getCategoryId, categoryId);
        lambdaQueryWrapper.eq(Dish::getStatus, status);
        lambdaQueryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> dishList = dishService.list(lambdaQueryWrapper);

        ArrayList<DishDto> dishDtoArrayList = new ArrayList<>();

        dishList.forEach(dish -> {
            DishDto dishDto=new DishDto();
            BeanUtils.copyProperties(dish,dishDto);
            Category category= categoryService.getById(dish.getCategoryId());
            dishDto.setCategoryName(category.getName());
            LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
            dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId, dish.getId());
            List<DishFlavor> dishFlavorList = dishFlavorService.list(dishFlavorLambdaQueryWrapper);
            dishDto.setFlavors(dishFlavorList);
            dishDtoArrayList.add(dishDto);

        });

        return CommonReturn.success(dishDtoArrayList);

    }
}
