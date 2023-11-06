package com.neu.administrator.config;

import com.neu.administrator.constants.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName TaskMqConfig
 * @Description TODO
 * @Author CY
 * @Date 2023/11/5 21:36
 * @Version 1.0
 */
@Configuration
public class TaskMqConfig {
    @Bean
    public TopicExchange taskTopicExchange(){
        return new TopicExchange(MqConstants.TASK_EXCHANGE, true, false);
    }

    @Bean
    public Queue allocateQueue(){
        return new Queue(MqConstants.TASK_VOL_ALLOCATE_QUEUE, true);
    }



    @Bean
    public Binding allocateQueueBinding(){
        return BindingBuilder.bind(allocateQueue()).to(taskTopicExchange()).with(MqConstants.TASK_VOL_ALLOCATE_KEY);
    }
}
