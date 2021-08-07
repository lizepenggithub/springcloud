package com.xiaoshen.springcloud.alibaba.service;

import com.xiaoshen.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: xs
 * @Date: 2021/8/5
 * @Description: com.xiaoshen.springcloud.alibaba.service
 * @Version: 1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
