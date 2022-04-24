package com.example.rabbitmq.producer;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weizihan
 */
@Configuration
public class DelayRabbitConfig {

    @Bean
    public Queue delayQueue(){
        return new Queue("delayQueue", true, false, false);
    }

    @Bean
    public DirectExchange delayExchange(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        DirectExchange exchange = new DirectExchange("delayExchange", true, false);
        exchange.setDelayed(true);
        return exchange;
    }

    @Bean
    public Binding delayBinding(){
        return BindingBuilder
                .bind(delayQueue())
                .to(delayExchange())
                .with("delayRouting");
    }
}
