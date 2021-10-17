package com.itheima.reggie_take_out.service;

import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.dto.SetmealDto;

import java.util.List;

/**
 * @author UMP90
 * @date 2021/10/16
 */

public interface SetmealDtoService {
    public CommonReturn<?> saveWithDish(SetmealDto setmealDto);
    public CommonReturn<?> page(Integer page, Integer pageSize, String name);
    public CommonReturn<?> deleteByIds(List<Long> ids);
    public CommonReturn<?> updateStatus(List<Long> ids,Integer status);
    public CommonReturn<?> getByCategoryId(Long categoryId, Integer status);
}
