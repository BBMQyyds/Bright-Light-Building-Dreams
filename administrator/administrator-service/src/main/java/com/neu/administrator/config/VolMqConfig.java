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
    /*
    *   @Select("select item_name from supplies_type where item_type = #{itemType}")
    String selectNameByType(@Param("itemType") String itemType);*/
    @Bean
    public TopicExchange volTopicExchange(){
        return new TopicExchange(MqConstants.VOL_EXCHANGE, true, false);
    }

    @Bean
    public Queue volInsertQueue(){
        return new Queue(MqConstants.VOL_INSERT_QUEUE, true);
    }

    @Bean
    public Queue volDeleteQueue(){
        return new Queue(MqConstants.VOL_DELETE_QUEUE, true);
    }

    @Bean
    public Binding volInsertQueueBinding(){
        return BindingBuilder.bind(volInsertQueue()).to(volTopicExchange()).with(MqConstants.VOL_INSERT_KEY);
    }

    @Bean
    public Binding volDeleteQueueBinding(){
        return BindingBuilder.bind(volDeleteQueue()).to(volTopicExchange()).with(MqConstants.VOL_DELETE_KEY);
    }
}
