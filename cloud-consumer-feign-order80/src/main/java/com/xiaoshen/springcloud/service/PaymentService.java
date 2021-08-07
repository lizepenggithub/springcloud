package com.xiaoshen.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: xs
 * @Date: 2021/7/24
 * @Description: com.xiaoshen.springcloud.service
 * @Version: 1.0
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/lb")
    public String paymentLb();

    @GetMapping("/payment/feignTimeout")
    public String paymentFeignTimeout();
}
