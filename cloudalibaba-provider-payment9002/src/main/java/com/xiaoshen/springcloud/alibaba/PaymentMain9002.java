package com.xiaoshen.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: xs
 * @Date: 2021/7/31
 * @Description: com.xiaoshen.springcloud.alibaba
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9002.class, args);
    }
}
