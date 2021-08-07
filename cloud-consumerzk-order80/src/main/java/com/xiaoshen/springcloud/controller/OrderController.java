package com.xiaoshen.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/7/23
 * @Description: com.xiaoshen.springcloud.controller
 * @Version: 1.0
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String INVOCE_URL = "http://cloud-payment-service";

    @GetMapping("/consumer/payment/zk")
    public String paymentZK() {
        return restTemplate.getForObject(INVOCE_URL + "/payment/zk", String.class);
    }
}
