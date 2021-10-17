package com.itheima.reggie_take_out.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.entity.ShoppingCart;

/**
 * @author UMP90
 * @date 2021/10/17
 */

public interface ShoppingCartService extends IService<ShoppingCart> {
    public CommonReturn<?> addIntoShoppingCart(ShoppingCart shoppingCart);
    public CommonReturn<?> listShoppingCart();
    public CommonReturn<?> cleanShoppingCart();
 }
