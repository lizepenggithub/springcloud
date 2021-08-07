package com.xiaoshen.springcloud.controller;

import com.xiaoshen.springcloud.entity.CommonResult;
import com.xiaoshen.springcloud.entity.Payment;
import com.xiaoshen.springcloud.lb.LoadBalanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: xs
 * @Date: 2021/7/21
 * @Description: com.xiaoshen.order.controller
 * @Version: 1.0
 */
@RestController
public class OrderController {

    private static final String PAYURL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalanced loadBalanced;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/order/payment/add")
    public CommonResult<Payment> add(Payment payment) {
        return restTemplate.postForObject(PAYURL + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/order/payment/get/{id}")
    public CommonResult<Payment> add(@PathVariable(value = "id")Long id) {
        return restTemplate.getForObject(PAYURL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/order/payment/lb")
    public String paymentLb () {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalanced.getInstance(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/lb", String.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject("http://localhost:8001/payment/zipkin/", String.class);
    }
}
