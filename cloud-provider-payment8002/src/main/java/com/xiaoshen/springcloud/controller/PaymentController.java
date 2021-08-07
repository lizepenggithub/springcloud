package com.xiaoshen.springcloud.controller;

import com.xiaoshen.springcloud.entity.CommonResult;
import com.xiaoshen.springcloud.entity.Payment;
import com.xiaoshen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: xs
 * @Date: 2021/7/21
 * @Description: com.xiaoshen.payment.controller
 * @Version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/add")
    public CommonResult add(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("保存结果中国人 " + result);
        if (result > 0) {
            return new CommonResult(200, "成功", result);
        } else {
            return new CommonResult(444, "失败", result);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult findById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.findById(id);
        log.info("查询结果123455555" + payment);
        if (payment != null ) {
            return new CommonResult(200, "成功  " + port, payment);
        } else {
            return new CommonResult(444, "失败", null);
        }
    }

    @GetMapping("/payment/info")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service: services) {
            log.info("service : " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String paymentLb() {
        return port;
    }

    @GetMapping("/payment/feignTimeout")
    public String paymentFeignTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
