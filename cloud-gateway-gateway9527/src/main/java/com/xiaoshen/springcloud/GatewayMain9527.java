package com.xiaoshen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: xs
 * @Date: 2021/7/27
 * @Description: com.xiaoshen.springcloud
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_routh_xs", r -> r.path("/guonei").uri("https://news.baidu.com/guonei"));
        return routes.build();
    }
}
