package com.blbd.children.service.impl;

import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.mapper.TaskMapper;
import com.blbd.children.service.FileService;
import com.blbd.children.service.TaskChildService;
import com.blbd.children.service.TaskService;
import com.blbd.children.utils.MinioUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/8 - 21:33
 */
@Service
public class FileServiceImpl implements FileService {
    private static final Logger Runtimelogger = LoggerFactory.getLogger("RuntimeLogger");

    @Autowired
    MinioUtil minioUtil;

    @Autowired
    private TaskChildService taskChildService;

    @Autowired
    private TaskMapper taskMapper;

    /**
     * 显示当前孩子当前任务（作业）的图片
     */
    @Override
    public void getTaskChildPhoto(String childId,String taskId, HttpServletResponse httpServletResponse) {
        String objectName = taskChildService.selectHomeworkPhoto(childId, taskId);

        if (objectName == null || objectName.equals("")){
            Runtimelogger.error("FileServiceImpl.getTaskChildPhoto:获取作业图片失败");
        } else {
            try {
                minioUtil.download(objectName,httpServletResponse);
            } catch (Exception e){
                Runtimelogger.error("FileServiceImpl.getTaskChildPhoto:获取作业图片失败");
            }
        }
    }

    /**
     * 当前孩子上传当前任务（作业）的图片
     */
    @Override
    public int uploadTaskChildPhoto(String childId,String taskId, MultipartFile file) {
        String objectName = minioUtil.upload(file);

        if (objectName == null || objectName.equals("")){
            Runtimelogger.error("FileServiceImpl.uploadTaskChildPhoto:上传作业图片失败");

            return -1;
        } else {
            Runtimelogger.info("FileServiceImpl.uploadTaskChildPhoto:上传作业图片成功");

            TaskChild taskChild = new TaskChild();

            Task task = taskMapper.selectById(taskId);
            taskChild.setChildId(childId);
            taskChild.setTaskId(taskId);
            taskChild.setScore(task.getScore());
            taskChild.setTaskStartTime(task.getStartTime());
            taskChild.setTaskEndTime(task.getFinishTime());
            taskChild.setHomeworkPhoto(objectName);

            int result = taskChildService.addTaskChild(taskChild);

            if (result == 1){
                Runtimelogger.info("FileServiceImpl.uploadTaskChildPhoto:调用服务成功");
            } else {
                Runtimelogger.error("FileServiceImpl.uploadTaskChildPhoto:调用服务失败");
            }

            return result;
        }
    }
}
