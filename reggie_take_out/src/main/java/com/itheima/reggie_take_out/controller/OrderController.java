package com.itheima.reggie_take_out.controller;

import com.itheima.reggie_take_out.common.CommonReturn;
import com.itheima.reggie_take_out.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author UMP90
 * @date 2021/10/17
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @PostMapping("/submit")
    public CommonReturn<?> submit(@RequestBody Map<String, String> map) {
        String remark = map.get("remark");
        Integer payMethod = Integer.parseInt(map.get("payMethod"));
        Long addressBookId = Long.parseLong(map.get("addressBookId"));
        return orderService.submitOrder(remark, payMethod, addressBookId);

    }
}
