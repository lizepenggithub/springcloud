package com.xiaoshen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: xs
 * @Date: 2021/7/22
 * @Description: com.xiaoshen.springcloud
 * @Version: 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain.class, args);
    }
}
