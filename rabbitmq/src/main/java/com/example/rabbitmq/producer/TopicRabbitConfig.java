package com.example.rabbitmq.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weizihan
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue topicQueueA(){
        return new Queue("topicA", true, false, false);
    }

    @Bean
    public Queue topicQueueB(){
        return new Queue("topicB", true, false, false);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange", true, false);
    }

    @Bean
    public Binding bindingTopicExchangeA(){
        return BindingBuilder
                .bind(topicQueueA())
                .to(topicExchange())
                .with("topic.a");
    }

    @Bean
    public Binding bindingTopicExchangeB(){
        return BindingBuilder
                .bind(topicQueueB())
                .to(topicExchange())
                .with("a.#");
    }
}
