package com.xiaoshen.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaoshen.springcloud.handler.SentinelHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xs
 * @Date: 2021/8/1
 * @Description: com.xiaoshen.springcloud.controller
 * @Version: 1.0
 */
@RestController
public class FlowLimitController {

    @GetMapping("/sentinel/testA")
    public String testA() {
        return "testA";
    }

    @GetMapping("/sentinel/testB")
    public String testB() {
        return "testB";
    }

    @GetMapping("/sentinel/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "sentinel_deal")
    public String sentinelHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return "hot key";
    }

    public String sentinel_deal(String p1, String p2, BlockException ex) {
        return "xxx     hot key";
    }

    @GetMapping("/sentinel/handler")
    @SentinelResource(value = "handler", blockHandlerClass = SentinelHandler.class, blockHandler = "exceptionHandler")
    public String sentinelHandler() {
        return "sentinelHandler";
    }
}
