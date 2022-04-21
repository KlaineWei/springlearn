package com.example.rabbitmq.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author weizihan
 */
@Component
@Slf4j
@RabbitListener(queues = "topicA")
public class TopicReceiverA {

    @RabbitHandler
    public void process(Map msg){
        log.info("topicA收到消息：{}", msg);
    }
}
