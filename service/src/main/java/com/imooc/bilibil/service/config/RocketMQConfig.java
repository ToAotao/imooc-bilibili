package com.imooc.bilibil.service.config;


import com.imooc.bilibili.domain.constant.UserMomentConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;

import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.List;

@Configuration
public class RocketMQConfig {
    @Value("${rocketmq.name.server.address}")
    private String nameServerAddr;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Bean("momentProducer")
    public DefaultMQProducer momentProducer() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(UserMomentConstant.GROUP_MOMENT);
        producer.setNamesrvAddr(nameServerAddr);
        producer.start();
        return producer;
    }
    @Bean("momentConsumer")
    public DefaultMQPushConsumer momentsConsumer() throws Exception{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(UserMomentConstant.GROUP_MOMENT);
        consumer.setNamesrvAddr(nameServerAddr);
        consumer.subscribe(UserMomentConstant.TOPIC_MOMENT, "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context){
                for (MessageExt msg : msgs) {
                    System.out.println(msg);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        return consumer;
    }

}
