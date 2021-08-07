package com.xiaoshen.springcloud.service;

import com.xiaoshen.springcloud.entity.Payment;

/**
 * @Auther: xs
 * @Date: 2021/7/21
 * @Description: com.xiaoshen.payment.service
 * @Version: 1.0
 */
public interface PaymentService {

    public int add(Payment payment);

    public Payment findById(Long id);
}
