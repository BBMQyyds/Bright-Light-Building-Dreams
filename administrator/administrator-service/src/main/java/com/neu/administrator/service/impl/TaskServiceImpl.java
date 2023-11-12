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
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neu.administrator.model.dto.TaskDto;
import com.neu.administrator.model.dto.VolunteerDto;
import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.Task;
import com.neu.administrator.model.po.TaskChild;
import com.neu.administrator.service.ChildService;
import com.neu.base.model.PageParams;
import com.neu.base.model.PageResult;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScriptScoreFunctionBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName TaskServiceImpl
 * @Description TODO
 * @Author CY
 * @Date 2023/11/6 16:14
 * @Version 1.0
 */
@Service
public class TaskServiceImpl  extends ServiceImpl<TaskMapper, Task> implements TaskService {
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


    @Autowired
    private ChildService childService;




    //儿童完成任务，分配给志愿者批改
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

    //新增和修改任务
    @Override
    public boolean saveTask(Task task){
        String id=task.getId();
        LambdaQueryWrapper<Task> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Task::getId,id);
        Task temp=taskMapper.selectOne(queryWrapper);
        //如果存在
        if(temp!=null){
            taskMapper.updateById(task);
            return true;
        }else {
            taskMapper.insert(task);
            return false;
        }
    }

    //查询分页
    @Override
    public PageResult<Task> searchTasks(PageParams pageParams, Task task){
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Task::getName,task.getName());
        //queryWrapper.like(Task::getContent,task.getContent());
        //分页参数
        Page<Task> page=new Page<>(pageParams.getPageNo(),pageParams.getPageSize());
        Page<Task> result =taskMapper.selectPage(page,queryWrapper);
        //数据
        List<Task> items=result.getRecords();
        //总记录数
        long total=result.getTotal();
        //准备返回数据
        PageResult<Task> taskPageResult =new PageResult<>(items,total,pageParams.getPageNo(),pageParams.getPageSize());

        return taskPageResult;
    }


    //发布任务
    public boolean publishTask(Task task){
        String status=task.getStatus();

        if(!status.equals("Not Started")){
            return false;
        }else {
            task.setStatus("In Progress");
            taskMapper.updateById(task);
            return true;
        }

    }

    //给孩子分配任务
    public void allocateTaskToChild(TaskDto taskDto){
        //前端提供一个孩子的id列表和一个任务id。
        // 你要把这个任务分配给这些孩子。
        List<Child> children= taskDto.getChildren();
        System.out.println("allocateTaskToChild-service:"+children);
        String taskId= taskDto.getTaskId();
        System.out.println("allocateTaskToChild-service:"+taskId);
        TaskChild taskChild=new TaskChild();
        for (Child child : children) {
            Task temp=taskMapper.selectById(taskId);
            System.out.println("allocateTaskToChild-service:"+temp);
            // 你要把这个任务分配给这些孩子。
            taskChild.setChildId(child.getId());
            taskChild.setTaskId(taskId);
            LocalDateTime startTime=temp.getStartTime();
            LocalDateTime endTime=temp.getFinishTime();
            taskChild.setTaskStartTime(startTime);
            taskChild.setTaskEndTime(endTime);
            taskChildMapper.insertTaskChild(taskChild);
        }

    }

    //给志愿者分配任务
    public void allocateHelpTaskToVol(VolunteerDto volunteerDto){
        //前端提供一个志愿者id和一个孩子id
        String volId=volunteerDto.getVolId();
        String childId=volunteerDto.getChild().getId();
        //给孩子插一个志愿者id
        LambdaQueryWrapper<Child> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Child::getId,childId);
        Child temp=childService.getOne(queryWrapper);
        temp.setVolunteerId(volId);
    }


}

