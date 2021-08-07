package com.xiaoshen.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaoshen.springcloud.alibaba.service.PaymentService;
import com.xiaoshen.springcloud.entity.CommonResult;
import com.xiaoshen.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: xs
 * @Date: 2021/8/2
 * @Description: com.xiaoshen.springcloud.alibaba.controller
 * @Version: 1.0
 */
@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/paymentSql/{id}")
//    @SentinelResource(value = "fallback", fallback = "handler")
//    @SentinelResource(value = "fallback", blockHandler = "handlerBlock")
    @SentinelResource(value = "fallback", fallback = "handler", blockHandler = "handlerBlock", exceptionsToIgnore = {})
    public CommonResult<Payment> fallback(@PathVariable(value = "id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serviceUrl + "/paymentSql/" + id, CommonResult.class);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("该ID没有对应记录,空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> handler(@PathVariable(value = "id") Long id, Throwable ta) {
        return new CommonResult<>(444, "handler 异常信息：" + ta.getMessage());
    }

    public CommonResult<Payment> handlerBlock(@PathVariable(value = "id") Long id, BlockException ta) {
        return new CommonResult<>(444, "handlerBlock 异常信息：" + ta.getMessage());
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSql2/{id}")
    public CommonResult<Payment> paymentSql2(@PathVariable(value = "id") Long id) {
        return paymentService.paymentSql(id);
    }


}
