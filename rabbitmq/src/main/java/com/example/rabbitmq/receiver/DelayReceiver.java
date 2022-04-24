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
@RabbitListener(queues = "delayQueue")
public class DelayReceiver {

    @RabbitHandler
    public void process(Map testMessage){
        log.info("延迟队列收到消息：{}", testMessage);

    }
}
