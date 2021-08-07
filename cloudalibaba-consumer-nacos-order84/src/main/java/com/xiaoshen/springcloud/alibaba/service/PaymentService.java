package com.xiaoshen.springcloud.alibaba.service;

import com.xiaoshen.springcloud.entity.CommonResult;
import com.xiaoshen.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: xs
 * @Date: 2021/8/3
 * @Description: com.xiaoshen.springcloud.alibaba.service
 * @Version: 1.0
 */
//@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)

@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceHandler.class)
public interface PaymentService {

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
