package com.xiaoshen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xs
 * @Date: 2021/7/23
 * @Description: com.xiaoshen.springcloud.controller
 * @Version: 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul")
    public String payment() {
        return "springcloud consul port: " + port;
    }
}
