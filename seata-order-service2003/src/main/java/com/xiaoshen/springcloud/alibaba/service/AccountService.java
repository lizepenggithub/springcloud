package com.xiaoshen.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @Auther: xs
 * @Date: 2021/8/6
 * @Description: com.xiaoshen.springcloud.alibaba.service
 * @Version: 1.0
 */
public interface AccountService {

    // 扣减库存
    void decrease(Long userId, BigDecimal money);
}
