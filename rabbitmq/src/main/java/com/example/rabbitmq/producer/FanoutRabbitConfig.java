package com.example.rabbitmq.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weizihan
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue queueA(){
        return new Queue("fanoutA", true, false, false);
    }

    @Bean
    public Queue queueB(){
        return new Queue("fanoutB", true, false, false);
    }

    @Bean
    public Queue queueC(){
        return new Queue("fanoutC", true, false, false);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange", true, false);
    }

    @Bean
    public Binding bindingExchangeQueueA(){
        return BindingBuilder
                .bind(queueA())
                .to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeQueueB(){
        return BindingBuilder
                .bind(queueB())
                .to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeQueueC(){
        return BindingBuilder
                .bind(queueC())
                .to(fanoutExchange());
    }
}
