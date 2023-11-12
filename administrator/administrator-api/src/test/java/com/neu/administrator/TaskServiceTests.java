//package com.neu.administrator;
//
//import com.neu.administrator.model.dto.TaskDto;
//import com.neu.administrator.model.po.TaskChild;
//import com.neu.administrator.model.po.TaskVolunteer;
//import com.neu.administrator.service.TaskChildService;
//import com.neu.administrator.service.TaskService;
//import com.neu.administrator.service.TaskVolunteerService;
//import com.neu.base.model.PageParams;
//import com.neu.base.model.PageResult;
//import com.neu.base.model.message.AllocateTaskVolMessage;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//
///**
// * @ClassName AllocateTaskServiceTests
// * @Description TODO
// * @Author CY
// * @Date 2023/11/6 17:12
// * @Version 1.0
// */
//@SpringBootTest
//public class TaskServiceTests {
//    @Autowired
//    TaskService taskService;
//
//    @Autowired
//    TaskChildService taskChildService;
//
//    @Autowired
//    TaskVolunteerService taskVolunteerService;
//
//
//    @Test
//    void searchTaskChildTest(){
//        TaskDto taskDto = new TaskDto();
//        taskDto.setTaskId("1");
//        PageParams pageParams = new PageParams();
//        pageParams.setPageNo(1L);
//        pageParams.setPageSize(10L);
//        PageResult<TaskChild> taskChildPageResult = taskChildService.searchTasks(taskDto, pageParams);
//
//
//        System.out.println(taskChildPageResult);
//    }
//
//    @Test
//    void allocateTaskToVolTest(){
//        AllocateTaskVolMessage allocateTaskVolMessage=new AllocateTaskVolMessage();
//        allocateTaskVolMessage.setTaskId("4");
//        allocateTaskVolMessage.setChildId("4");
//
//        taskService.allocateTaskToVol(allocateTaskVolMessage);
//    }
//
//
//    @Test
//    void assignTaskTest(){
//        TaskVolunteer taskVolunteer = new TaskVolunteer();
//
//        taskVolunteer.setTaskId("2");
//        taskVolunteer.setChildId("1");
//        taskVolunteer.setVolunteerId("111111");
//        taskVolunteerService.assignTask(taskVolunteer);
//    }
//}
