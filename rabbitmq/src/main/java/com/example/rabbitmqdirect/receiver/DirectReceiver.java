package com.example.rabbitmqdirect.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author weizihan
 * @RabbitListener 定义这是消费者
 * @RabbitHandler 当声明的队列收到消息时，就交给@RabbitHandler修饰的方法处理
 */
@Component
@RabbitListener(queues = "directQueue")
@Slf4j
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage){
        log.info("DirectReceiver消费者收到的消息： {}", testMessage);
    }
}
