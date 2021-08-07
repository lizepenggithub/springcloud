package com.xiaoshen.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @Auther: xs
 * @Date: 2021/7/24
 * @Description: com.xiaoshen.springcloud.service
 * @Version: 1.0
 */
@Service
public class PaymentService {

    public String payment(Integer id) {
        return "线程： " + Thread.currentThread().getName() + " payment " + " id : " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentFallback", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeout(Integer id) {
//        int i = 10 / 0;
        int timeout = 2000;
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程： " + Thread.currentThread().getName() + " paymentTimeout " + " id : " + id;
    }

    public String paymentFallback(Integer id) {
        return "故障 程序异常   :   线程： " + Thread.currentThread().getName() + " paymentTimeout " + " id : " + id;
    }

    //  服务熔断
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启断路器
            // 10000毫秒的时间间隔内，10 次有60%失败，开启断路
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   // 时间间隔
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")    // 请求失败率
    })
    public String circuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id xxx");
        }
        String uuid = IdUtil.simpleUUID();
        return "线程： " + Thread.currentThread().getName() + " circuitBreaker " + " uuid : " + uuid;
    }

    public String circuitBreakerFallback(Integer id) {
        return "断路器起作用";
    }
}
