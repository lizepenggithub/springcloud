package com.xiaoshen.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Auther: xs
 * @Date: 2021/7/26
 * @Description: com.xiaoshen.springcloud.service
 * @Version: 1.0
 */
@Component
public class FeignHystrixServiceImpl implements FeignHystrixService {
    @Override
    public String payment(Integer id) {
        return "服务不可用    8001";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return null;
    }
}
