package com.xiaoshen.springcloud.controller;

import com.xiaoshen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/7/24
 * @Description: com.xiaoshen.springcloud.controller
 * @Version: 1.0
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/payment/{id}")
    public String payment(@PathVariable("id") Integer id) {
        return paymentService.payment(id);
    }

    @GetMapping("/payment/paymentTimeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id) {
        return paymentService.paymentTimeout(id);
    }

    @GetMapping("/payment/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.circuitBreaker(id);
    }
}
