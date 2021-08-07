package com.xiaoshen.springcloud.service.impl;

import com.xiaoshen.springcloud.dao.PaymentDao;
import com.xiaoshen.springcloud.entity.Payment;
import com.xiaoshen.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/7/21
 * @Description: com.xiaoshen.payment.service.impl
 * @Version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    public Payment findById(Long id) {
        return paymentDao.findById(id);
    }
}
