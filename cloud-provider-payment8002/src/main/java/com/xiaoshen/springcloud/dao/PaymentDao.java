package com.xiaoshen.springcloud.dao;

import com.xiaoshen.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: xs
 * @Date: 2021/7/21
 * @Description: com.xiaoshen.payment
 * @Version: 1.0
 */
@Mapper
public interface PaymentDao {

    public int add(Payment payment);

    public Payment findById(Long id);
}
