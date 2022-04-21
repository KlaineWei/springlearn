package com.example.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author weizihan
 */
@RestController
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sendDirectMessage")
    public String sendDirectMessage(String msg, String route){
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", msg);
        map.put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // 通过交换机和声明的路由给队列发送消息
//        rabbitTemplate.convertAndSend("directExchange", "directRouting", map);
        // 通过队列名直接给队列发送消息
//        rabbitTemplate.convertAndSend("directQueue", map);
        // fanoutExchange 只需要指定交换机
//        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        // topicExchange 指定交换机和路由
        rabbitTemplate.convertAndSend("topicExchange", route, map);
        return "OK!";
    }
}
