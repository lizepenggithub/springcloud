package com.xiaoshen.springcloud.alibaba.service.impl;

import com.xiaoshen.springcloud.alibaba.mapper.AccountMapper;
import com.xiaoshen.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: xs
 * @Date: 2021/8/6
 * @Description: com.xiaoshen.springcloud.alibaba.service.impl
 * @Version: 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountMapper accountMapper;

    // 扣减账户余额
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service中扣减账户余额开始");
        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        accountMapper.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}
