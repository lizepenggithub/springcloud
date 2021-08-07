package com.xiaoshen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xs
 * @Date: 2021/7/28
 * @Description: com.xiaoshen.springcloud.controller
 * @Version: 1.0
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo + "    端口： " + serverPort;
    }
}
