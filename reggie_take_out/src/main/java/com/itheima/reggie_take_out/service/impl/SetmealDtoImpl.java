package com.itheima.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.dto.SetmealDto;
import com.itheima.reggie_take_out.entity.Setmeal;
import com.itheima.reggie_take_out.entity.SetmealDish;
import com.itheima.reggie_take_out.service.CategoryService;
import com.itheima.reggie_take_out.service.SetmealDishService;
import com.itheima.reggie_take_out.service.SetmealDtoService;
import com.itheima.reggie_take_out.service.SetmealService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UMP90
 * @date 2021/10/16
 */
@Service
public class SetmealDtoImpl implements SetmealDtoService {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private SetmealDishService setmealDishService;
    @Autowired
    private CategoryService categoryService;

    @Override
    @Transactional
    public CommonReturn<?> saveWithDish(SetmealDto setmealDto) {
        setmealService.save(setmealDto);
        Long setmealId = setmealDto.getId();
        List<SetmealDish> setmealDishList = setmealDto.getSetmealDishes();
        setmealDishList.forEach(setmealDish -> {
            setmealDish.setSetmealId(setmealId);
        });
        setmealDishService.saveBatch(setmealDishList);
        return CommonReturn.success("套餐保存成功");
    }

    @Override
    @Transactional
    public CommonReturn<?> page(Integer page, Integer pageSize, String name) {
        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<Setmeal> setmealPage = new Page<>(page, pageSize);
        Page<SetmealDto> setmealDtoPage=new Page<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(name), Setmeal::getName, name);
        lambdaQueryWrapper.orderByDesc(Setmeal::getUpdateTime);
        setmealService.page(setmealPage,lambdaQueryWrapper);
        List<Setmeal> setmealList=setmealPage.getRecords();
        List<SetmealDto> setmealDtos = new ArrayList<>();
        setmealList.forEach(setmeal -> {
            Long categoryId = setmeal.getCategoryId();
            String categoryName = categoryService.getById(categoryId).getName();
            SetmealDto setmealDto=new SetmealDto();
            BeanUtils.copyProperties(setmeal,setmealDto);
            setmealDto.setCategoryName(categoryName);
            setmealDtos.add(setmealDto);
        });
        BeanUtils.copyProperties(setmealPage,setmealDtoPage,"records");
        setmealDtoPage.setRecords(setmealDtos);
        return CommonReturn.success(setmealDtoPage);
    }
}
