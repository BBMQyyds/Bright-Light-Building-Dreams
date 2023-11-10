package com.blbd.children.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/5 - 11:02
 */
@Slf4j  //日志
@Component  //丢到springboot里,一定不要忘记把处理器加到Ioc容器中!
//元数据处理器
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override   //插入时的填充策略
    public void insertFill(MetaObject metaObject) {
        log.info("==start insert ······==");

        this.setFieldValByName("date",new Date(),metaObject);
        this.setFieldValByName("status",false,metaObject);
        this.setFieldValByName("taskFinishTime",new Date(),metaObject);
        this.setFieldValByName("isCompleted",true,metaObject);
        this.setFieldValByName("isCorrected",0,metaObject);
        this.setFieldValByName("assignmentStage","1",metaObject);
        this.setFieldValByName("comments",null,metaObject);
        this.setFieldValByName("taskApproveTime",null,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("==start update ······==");

        //即作业重新提交时需要重置
        this.setFieldValByName("taskFinishTime",new Date(),metaObject);
        this.setFieldValByName("isCompleted",true,metaObject);
        this.setFieldValByName("isCorrected",0,metaObject);
        this.setFieldValByName("assignmentStage","1",metaObject);
        this.setFieldValByName("comments",null,metaObject);
        this.setFieldValByName("taskApproveTime",null,metaObject);
    }
}
