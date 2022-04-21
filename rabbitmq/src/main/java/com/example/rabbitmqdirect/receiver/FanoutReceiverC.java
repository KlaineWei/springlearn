package com.example.rabbitmqdirect.receiver;

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
@RabbitListener(queues = "fanoutC")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(Map msg){
        log.info("fanoutC收到消息：{}", msg);
    }
}
