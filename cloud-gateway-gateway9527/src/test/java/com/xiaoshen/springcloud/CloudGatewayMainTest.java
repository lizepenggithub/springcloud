package com.xiaoshen.springcloud;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * @Auther: xs
 * @Date: 2021/7/27
 * @Description: com.xiaoshen.springcloud
 * @Version: 1.0
 */
public class CloudGatewayMainTest {

    public static void main(String[] args) {
        ZonedDateTime d = ZonedDateTime.now();
        System.out.println(d);
    }
}
