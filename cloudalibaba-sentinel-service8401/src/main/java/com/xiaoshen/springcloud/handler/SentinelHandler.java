package com.xiaoshen.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Auther: xs
 * @Date: 2021/8/2
 * @Description: com.xiaoshen.springcloud.handler
 * @Version: 1.0
 */
public class SentinelHandler {

    public static String exceptionHandler(BlockException ex) {
        return "自定义sentinel处理类";
    }
}
