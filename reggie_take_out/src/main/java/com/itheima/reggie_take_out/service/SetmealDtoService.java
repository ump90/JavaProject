package com.itheima.reggie_take_out.service;

import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.dto.SetmealDto;

/**
 * @author UMP90
 * @date 2021/10/16
 */

public interface SetmealDtoService {
    public CommonReturn<?> saveWithDish(SetmealDto setmealDto);
    public CommonReturn<?> page(Integer page, Integer pageSize, String name);
}
