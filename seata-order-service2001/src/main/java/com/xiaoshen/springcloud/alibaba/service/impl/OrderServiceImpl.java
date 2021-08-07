package com.xiaoshen.springcloud.alibaba.service.impl;

import com.xiaoshen.springcloud.alibaba.domain.Order;
import com.xiaoshen.springcloud.alibaba.mapper.OrderMapper;
import com.xiaoshen.springcloud.alibaba.service.AccountService;
import com.xiaoshen.springcloud.alibaba.service.OrderService;
import com.xiaoshen.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/8/5
 * @Description: com.xiaoshen.springcloud.alibaba.service.impl
 * @Version: 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        // 1. 创建订单
        log.info("创建订单");
        orderMapper.createOrder(order);

        // 2. 减库存
        log.info("减库存");
        storageService.decrease(order.getProductId(), order.getCount());

        // 3. 扣除费用
        log.info("扣除费用");
        accountService.decrease(order.getUserId(), order.getMoney());

        // 4. 修改订单状态
        log.info("修改订单状态");
        orderMapper.updateOrder(order.getId());
    }
}
