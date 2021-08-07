package com.xiaoshen.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: xs
 * @Date: 2021/8/2
 * @Description: com.xiaoshen.springcloud.alibaba
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class OrderPayment84 {

    public static void main(String[] args) {
        SpringApplication.run(OrderPayment84.class, args);
    }
}
