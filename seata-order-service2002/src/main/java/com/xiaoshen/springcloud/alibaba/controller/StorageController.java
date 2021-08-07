package com.xiaoshen.springcloud.alibaba.controller;

import com.xiaoshen.springcloud.alibaba.domain.CommonResult;
import com.xiaoshen.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xs
 * @Date: 2021/8/6
 * @Description: com.xiaoshen.springcloud.alibaba.controller
 * @Version: 1.0
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
