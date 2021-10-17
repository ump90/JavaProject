package com.itheima.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie_take_out.common.BaseContext;
import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.entity.*;
import com.itheima.reggie_take_out.mapper.OrderMapper;
import com.itheima.reggie_take_out.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author UMP90
 * @date 2021/10/17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressBookService addressBookService;
    @Autowired
    private OrderDetailService orderDetailService;


    @Override
    public CommonReturn<?> submitOrder(String remark, Integer payMethod, Long addressBookId) {
        Long userId = BaseContext.getId();
        LambdaQueryWrapper<ShoppingCart> shoppingCartLambdaQueryWrapper = new LambdaQueryWrapper<>();
        shoppingCartLambdaQueryWrapper.eq(userId != null, ShoppingCart::getUserId, userId);
        List<ShoppingCart> shoppingCartList = shoppingCartService.list(shoppingCartLambdaQueryWrapper);
        User user = userService.getById(userId);
        LambdaQueryWrapper<AddressBook> addressBookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        addressBookLambdaQueryWrapper.eq(userId != null, AddressBook::getUserId, userId);
        addressBookLambdaQueryWrapper.eq(AddressBook::getIsDefault, 1);
        AddressBook addressBook = addressBookService.getOne(addressBookLambdaQueryWrapper);

        if (shoppingCartList == null) {
            return CommonReturn.error("购物车空空的，就像我的钱包");
        }
        if (addressBook == null) {
            return CommonReturn.error("没写送货地址");
        }

        Long orderId = IdWorker.getId();
        AtomicInteger atomicInteger = new AtomicInteger(0);

        List<OrderDetail> orderDetails = new ArrayList<>();
        final BigDecimal[] totalMoney = {BigDecimal.ZERO};

        shoppingCartList.forEach(shoppingCart -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setName(shoppingCart.getName());
            orderDetail.setImage(shoppingCart.getImage());
            orderDetail.setOrderId(orderId);
            orderDetail.setDishId(shoppingCart.getDishId());
            orderDetail.setDishFlavor(shoppingCart.getDishFlavor());
            orderDetail.setNumber(shoppingCart.getNumber());
            orderDetail.setAmount(shoppingCart.getAmount());
            orderDetails.add(orderDetail);
            atomicInteger.incrementAndGet();

            BigDecimal price = BigDecimal.valueOf(shoppingCart.getAmount());
            BigDecimal number = BigDecimal.valueOf(shoppingCart.getNumber());
            totalMoney[0] = totalMoney[0].add(price.multiply(number));
        });

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        Double orderAmount = Double.parseDouble(numberFormat.format(totalMoney[0]));
        Order order = new Order();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(addressBook.getProvinceName() != null ? addressBook.getProvinceName() : null)
                .append(addressBook.getCityName() != null ? addressBook.getCityName() : numberFormat)
                .append(addressBook.getDistrictName() != null ? addressBook.getCityName() : numberFormat)
                .append(addressBook.getDetail() != null ? addressBook.getDetail() : null);
        order.setAddress(stringBuilder.toString());
        order.setAddressBookId(addressBook.getId());
        order.setAmount(orderAmount);
        order.setConsignee(addressBook.getConsignee());
        order.setId(orderId);
        order.setNumber(orderId.toString());
        order.setPhone(user.getPhone());
        order.setRemark(remark);
        order.setOrderTime(LocalDateTime.now());
        order.setCheckOutTime(LocalDateTime.now());
        order.setStatus(2);
        order.setUserId(userId);
        order.setUserName(user.getName());
        order.setPayMethod(payMethod);
        this.save(order);
        orderDetailService.saveBatch(orderDetails);

        shoppingCartService.remove(shoppingCartLambdaQueryWrapper);


        return CommonReturn.success("下单成功");

    }
}
