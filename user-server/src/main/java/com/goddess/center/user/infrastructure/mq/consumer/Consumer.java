package com.goddess.center.user.infrastructure.mq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Consumer {

    String consumerGroup = "userProducer_t1";
    DefaultMQPushConsumer consumer;

    @Autowired
    UserListener userListener;

    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("test","*");
        consumer.registerMessageListener(userListener);
        consumer.start();
    }
}