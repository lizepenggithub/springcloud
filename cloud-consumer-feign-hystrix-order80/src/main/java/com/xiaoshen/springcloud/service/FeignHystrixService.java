package com.xiaoshen.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: xs
 * @Date: 2021/7/24
 * @Description: com.xiaoshen.springcloud.service
 * @Version: 1.0
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = FeignHystrixServiceImpl.class)
public interface FeignHystrixService {

    @GetMapping("/payment/payment/{id}")
    public String payment(@PathVariable("id") Integer id);

    @GetMapping("/payment/paymentTimeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id);
}
