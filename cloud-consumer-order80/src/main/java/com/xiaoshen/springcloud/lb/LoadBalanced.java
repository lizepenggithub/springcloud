package com.xiaoshen.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Auther: xs
 * @Date: 2021/7/24
 * @Description: com.xiaoshen.springcloud.lb
 * @Version: 1.0
 */
public interface LoadBalanced {

    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances);
}
