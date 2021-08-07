package com.xiaoshen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: xs
 * @Date: 2021/7/28
 * @Description: com.xiaoshen.springcloud
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigMain3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3355.class, args);
    }
}
