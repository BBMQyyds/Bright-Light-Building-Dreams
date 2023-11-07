package com.neu.administrator.service.impl;

import com.alibaba.fastjson.JSON;
import com.neu.administrator.mapper.ChildMapper;
import com.neu.administrator.mapper.TaskChildMapper;
import com.neu.administrator.mapper.TaskMapper;
import com.neu.administrator.mapper.TaskVolunteerMapper;
import com.neu.administrator.model.po.*;
import com.neu.administrator.service.TaskService;
import com.neu.base.exception.BlbdException;
import com.neu.base.model.message.AllocateTaskVolMessage;
import org.apache.commons.lang.ObjectUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.index.query.functionscore.ScriptScoreFunctionBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @ClassName TaskServiceImpl
 * @Description TODO
 * @Author CY
 * @Date 2023/11/6 16:14
 * @Version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private TaskChildMapper taskChildMapper;

    @Autowired
    private TaskVolunteerMapper taskVolunteerMapper;

    @Autowired
    private ChildMapper childMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void allocateTaskToVol(AllocateTaskVolMessage allocateTaskVolMessage) {
        // 创建RestHighLevelClient


        // 创建查询
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(QueryBuilders.matchAllQuery(),
                new ScriptScoreFunctionBuilder(new Script(
                        "_score * (doc['volCorrectedTasks'].value + 1) / (doc['volDuty'].value * doc['volDuty'].value + 1) * 100")));

        // 创建SearchSourceBuilder
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(functionScoreQueryBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(1);
        sourceBuilder.sort(SortBuilders.scoreSort().order(SortOrder.DESC));

        // 创建SearchRequest
        SearchRequest searchRequest = new SearchRequest("volunteer"); // 替换为你的索引名称
        searchRequest.source(sourceBuilder);


        // 执行查询
        SearchResponse searchResponse = null;
        try {
            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new BlbdException("分配任务失败");//、、、
        }

        // 处理查询结果
        SearchHit[] searchHits = searchResponse.getHits().getHits();

        String volunteerJson = searchHits[0].getSourceAsString();

        //分配到的志愿者
        Volunteer volunteer = JSON.parseObject(volunteerJson, Volunteer.class);

        //将分配阶段设为1
        taskChildMapper.updateAssignmentStage(allocateTaskVolMessage.getChildId(), allocateTaskVolMessage.getTaskId(), "1");

        //查出task_child
        TaskChild taskChild = taskChildMapper.selectByChildId(allocateTaskVolMessage.getChildId(), allocateTaskVolMessage.getTaskId());
        //在task_vol增加一条数据
        TaskVolunteer taskVolunteer=new TaskVolunteer();

        //三个时间+儿童id+任务id
        BeanUtils.copyProperties(allocateTaskVolMessage,taskVolunteer);

        //志愿者id
        taskVolunteer.setVolunteerId(volunteer.getVolId());
        //完成情况
        taskVolunteer.setCompletedApproval(false);

        //评论为空

        //作业照片
        taskVolunteer.setHomeworkPhoto(taskChild.getHomeworkPhoto());

        //儿童姓名
        Child child = childMapper.selectById(taskChild.getChildId());
        taskVolunteer.setChildName(child.getName());

        //任务名字
        Task task = taskMapper.selectById(taskChild.getTaskId());
        taskVolunteer.setTaskId(task.getId());

        System.out.println(taskVolunteer);

        //存入数据库
        taskVolunteerMapper.insert(taskVolunteer);


    }
}

