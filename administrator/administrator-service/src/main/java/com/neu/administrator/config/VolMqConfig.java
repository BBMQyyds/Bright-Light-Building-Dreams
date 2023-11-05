package com.neu.administrator.config;

import com.neu.administrator.constants.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName VolMqConfig
 * @Description 志愿者有关的队列配置
 * @Author CY
 * @Date 2023/11/5 21:28
 * @Version 1.0
 */
@Configuration
public class VolMqConfig {
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(MqConstants.VOL_EXCHANGE, true, false);
    }

    @Bean
    public Queue insertQueue(){
        return new Queue(MqConstants.VOL_INSERT_QUEUE, true);
    }

    @Bean
    public Queue deleteQueue(){
        return new Queue(MqConstants.VOL_DELETE_QUEUE, true);
    }

    @Bean
    public Binding insertQueueBinding(){
        return BindingBuilder.bind(insertQueue()).to(topicExchange()).with(MqConstants.VOL_INSERT_KEY);
    }

    @Bean
    public Binding deleteQueueBinding(){
        return BindingBuilder.bind(deleteQueue()).to(topicExchange()).with(MqConstants.VOL_DELETE_KEY);
    }
}
