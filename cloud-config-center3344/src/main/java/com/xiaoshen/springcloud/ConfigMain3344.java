package com.xiaoshen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: xs
 * @Date: 2021/7/28
 * @Description: com.xiaoshen.springcloud
 * @Version: 1.0
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3344.class, args);
    }
}
