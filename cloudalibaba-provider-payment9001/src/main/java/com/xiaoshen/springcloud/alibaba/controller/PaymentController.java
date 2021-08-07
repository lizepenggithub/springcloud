package com.xiaoshen.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xs
 * @Date: 2021/7/31
 * @Description: com.xiaoshen.springcloud.alibaba.controller
 * @Version: 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos")
    public  String paymentNacos() {
        return "nacos  请求返回   ，端口： " + serverPort;
    }
}
