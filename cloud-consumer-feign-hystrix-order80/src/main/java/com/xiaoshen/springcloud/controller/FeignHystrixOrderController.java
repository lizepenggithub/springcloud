package com.xiaoshen.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaoshen.springcloud.service.FeignHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/7/24
 * @Description: com.xiaoshen.springcloud.controller
 * @Version: 1.0
 */
@RestController
@DefaultProperties(defaultFallback = "globalDefaultFallback")
public class FeignHystrixOrderController {

    @Resource
    private FeignHystrixService feignHystrixService;

    @GetMapping("/order/payment/payment/{id}")
    public String payment(@PathVariable("id") Integer id) {
        return feignHystrixService.payment(id);
    }

    @GetMapping("/order/payment/paymentTimeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000")
    })
    public String paymentTimeout(@PathVariable("id") Integer id) {
        return feignHystrixService.paymentTimeout(id);
    }

    public String paymentFallback(@PathVariable("id") Integer id) {
        return "消费端80   故障 程序异常   :   线程： " + Thread.currentThread().getName() + " paymentTimeout " + " id : " + id;
    }

    @GetMapping("/order/payment/paymentTimeout2")
    public String paymentTimeout2() {
        return feignHystrixService.paymentTimeout(1);
    }

    @GetMapping("/order/payment/paymentTimeout3")
    @HystrixCommand
    public String paymentTimeout3() {
        return feignHystrixService.paymentTimeout(1);
    }

    public String globalDefaultFallback() {
        return "消费端80   全局默认服务降级方案  线程： " + Thread.currentThread().getName();
    }
}
