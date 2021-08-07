package com.xiaoshen.springcloud.alibaba.service;

/**
 * @Auther: xs
 * @Date: 2021/8/6
 * @Description: com.xiaoshen.springcloud.alibaba.service
 * @Version: 1.0
 */
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
}
