package com.xiaoshen.springcloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Auther: xs
 * @Date: 2021/7/29
 * @Description: com.xiaoshen.springcloud.service
 * @Version: 1.0
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider{

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("*****************" + uuid);
        return null;
    }
}
