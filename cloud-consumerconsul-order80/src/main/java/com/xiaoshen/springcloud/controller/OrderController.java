package com.xiaoshen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private String port;

    private static final String SERVERURL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String payment() {
        return restTemplate.getForObject(SERVERURL + "/payment/consul", String.class);
    }
}
