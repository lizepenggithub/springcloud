package com.xiaoshen.springcloud.controller;

import com.xiaoshen.springcloud.StreamMQMain8801;
import com.xiaoshen.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/7/29
 * @Description: com.xiaoshen.springcloud.controller
 * @Version: 1.0
 */
@RestController
public class SendController {

    @Resource
    private IMessageProvider provider;

    @GetMapping("/stream/send")
    public String send() {
        return provider.send();
    }
}
