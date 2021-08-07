package com.xiaoshen.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/7/31
 * @Description: com.xiaoshen.springcloud.alibaba.controller
 * @Version: 1.0
 */
@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos")
    public  String paymentNacos() {
        return restTemplate.getForObject(serviceUrl + "/payment/nacos", String.class);
    }
}