package com.xiaoshen;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: xs
 * @Date: 2021/7/23
 * @Description: com.xiaoshen
 * @Version: 1.0
 */
@Configuration
public class MyRule {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
