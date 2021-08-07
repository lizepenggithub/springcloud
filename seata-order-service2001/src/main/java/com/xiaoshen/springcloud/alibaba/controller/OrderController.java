package com.xiaoshen.springcloud.alibaba.controller;

import com.xiaoshen.springcloud.alibaba.domain.CommonResult;
import com.xiaoshen.springcloud.alibaba.domain.Order;
import com.xiaoshen.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/8/5
 * @Description: com.xiaoshen.springcloud.alibaba.controller
 * @Version: 1.0
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "下单成功");
    }
}
