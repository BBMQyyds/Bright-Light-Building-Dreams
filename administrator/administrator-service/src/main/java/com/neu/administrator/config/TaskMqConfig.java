package com.neu.administrator.config;

import com.neu.administrator.constants.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName TaskMqConfig
 * @Description TODO
 * @Author CY
 * @Date 2023/11/5 21:36
 * @Version 1.0
 */
public class TaskMqConfig {
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(MqConstants.TASK_EXCHANGE, true, false);
    }

    @Bean
    public Queue allocateQueue(){
        return new Queue(MqConstants.TASK_VOL_ALLOCATE_QUEUE, true);
    }



    @Bean
    public Binding allocateQueueBinding(){
        return BindingBuilder.bind(allocateQueue()).to(topicExchange()).with(MqConstants.TASK_VOL_ALLOCATE_KEY);
    }
}
