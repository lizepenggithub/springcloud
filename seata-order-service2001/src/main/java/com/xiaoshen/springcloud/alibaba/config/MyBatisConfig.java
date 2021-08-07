package com.xiaoshen.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: xs
 * @Date: 2021/8/5
 * @Description: com.xiaoshen.springcloud.alibaba.config
 * @Version: 1.0
 */
@Configuration
@MapperScan({"com.xiaoshen.springcloud.alibaba.mapper"})
public class MyBatisConfig {
}
