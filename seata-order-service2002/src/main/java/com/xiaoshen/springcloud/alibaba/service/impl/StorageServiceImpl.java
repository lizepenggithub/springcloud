package com.xiaoshen.springcloud.alibaba.service.impl;

import com.xiaoshen.springcloud.alibaba.mapper.StorageMapper;
import com.xiaoshen.springcloud.alibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/8/6
 * @Description: com.xiaoshen.springcloud.alibaba.service.impl
 * @Version: 1.0
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageMapper storageMapper;

    // 扣减库存
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        LOGGER.info("------->storage-service中扣减库存结束");
    }
}
