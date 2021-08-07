package com.xiaoshen.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: xs
 * @Date: 2021/7/23
 * @Description: com.xiaoshen.springcloud.config
 * @Version: 1.0
 */
@Configuration
public class OrderConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
