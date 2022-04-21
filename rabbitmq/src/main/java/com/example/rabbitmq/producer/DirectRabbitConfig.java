package com.example.rabbitmq.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weizihan
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 1.声明队列
     */
    @Bean
    public Queue directQueue(){
        return new Queue("directQueue", true, false, false);
    }

    /**
     * 2.声明交换机
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange", true, false);
    }

    /**
     * 3.将队列和交换机绑定，并声明路由
     */
    @Bean
    public Binding bindDirect(){
        return BindingBuilder
                .bind(directQueue())
                .to(directExchange())
                .with("directRouting");
    }
}
