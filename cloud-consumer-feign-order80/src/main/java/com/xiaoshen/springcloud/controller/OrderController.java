package com.xiaoshen.springcloud.controller;

import com.xiaoshen.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/7/24
 * @Description: com.xiaoshen.springcloud.controller
 * @Version: 1.0
 */
@RestController
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/order/payment/oflb")
    public String paymentLb() {
        return paymentService.paymentLb();
    }

    @GetMapping("/order/payment/feignTimeout")
    public String paymentFeignTimeout() {
        return paymentService.paymentFeignTimeout();
    }
}
