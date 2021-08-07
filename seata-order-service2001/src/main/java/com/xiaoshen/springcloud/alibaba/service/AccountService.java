package com.xiaoshen.springcloud.alibaba.service;

import com.xiaoshen.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Auther: xs
 * @Date: 2021/8/5
 * @Description: com.xiaoshen.springcloud.alibaba.service
 * @Version: 1.0
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
