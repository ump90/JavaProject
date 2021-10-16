package com.itheima.reggie_take_out.controller;

import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.dto.SetmealDto;
import com.itheima.reggie_take_out.service.SetmealDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author UMP90
 * @date 2021/10/16
 */
@RestController
@RequestMapping("setmeal")
public class SetmealController {
    @Autowired
    private SetmealDtoService setmealDtoService;

    @PostMapping
    public CommonReturn<?> save(@RequestBody SetmealDto setmealDto) {
        return setmealDtoService.saveWithDish(setmealDto);
    }

    public CommonReturn<?> page(@RequestParam Integer page, @RequestParam Integer pageSize, @RequestParam(required = false) String name) {
        return setmealDtoService.page(page, pageSize, name);
    }

}
