package com.xiaoshen.springcloud;

import com.xiaoshen.springcloud.entity.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: xs
 * @Date: 2021/7/23
 * @Description: com.xiaoshen.springcloud
 * @Version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class, args);
    }
}
