package com.xiaoshen.springcloud.alibaba.service;

import com.xiaoshen.springcloud.entity.CommonResult;
import com.xiaoshen.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @Auther: xs
 * @Date: 2021/8/3
 * @Description: com.xiaoshen.springcloud.alibaba.service
 * @Version: 1.0
 */
@Component
public class PaymentServiceHandler implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444, "feign 异常处理");
    }
}
