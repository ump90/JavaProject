package com.itheima.reggie_take_out.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.entity.Order;

/**
 * @author UMP90
 * @date 2021/10/17
 */

public interface OrderService extends IService<Order> {
    public CommonReturn<?> submitOrder(String remark,Integer payMethod,Long addressBookId);
}
