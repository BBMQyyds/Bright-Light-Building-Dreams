package com.blbd.children.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blbd.children.dao.entity.Task;
import com.blbd.children.dao.entity.TaskChild;
import com.blbd.children.mapper.TaskChildMapper;
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

    @Autowired
    private TaskChildMapper taskChildMapper;

    /**
     * 显示当前孩子当前任务（作业）的图片
     */
    @Override
    public void getTaskChildPhoto(String childId,String taskId, HttpServletResponse httpServletResponse) {
        String objectName = taskChildService.selectHomeworkPhoto(childId, taskId);
        objectName = objectName.substring(36, objectName.length());
        System.out.println(objectName);

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
     * 下载当前孩子当前任务（作业）的图片
     */
    @Override
    public void downloadTaskChildPhoto(String childId, String taskId, HttpServletResponse httpServletResponse) {
        String objectName = taskChildService.selectHomeworkPhoto(childId, taskId);
        objectName = objectName.substring(36, objectName.length());
        System.out.println(objectName);

        if (objectName == null || objectName.equals("")){
            Runtimelogger.error("FileServiceImpl.getTaskChildPhoto:获取作业图片失败");
        } else {
            try {
                // 设置响应头，告诉浏览器该文件需要下载
//                httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + objectName);

                // 使用 minioUtil.download 下载图片
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
            taskChild.setHomeworkPhoto("http://47.116.65.252:9000/taskchild/"+objectName);

            int result = taskChildService.addTaskChild(taskChild);

            if (result == 1){
                Runtimelogger.info("FileServiceImpl.uploadTaskChildPhoto:调用服务成功");
            } else {
                Runtimelogger.error("FileServiceImpl.uploadTaskChildPhoto:调用服务失败");
            }

            return result;
        }
    }

    /**
     * 重新上传当前孩子的作业图片
     */
    @Override
    public int uploadTaskChildPhotoAgain(String childId, String taskId, MultipartFile file) {
        String objectName = minioUtil.upload(file);

        if (objectName == null || objectName.equals("")){
            Runtimelogger.error("FileServiceImpl.uploadTaskChildPhoto:重新上传作业图片失败");

            return -1;
        } else {
            Runtimelogger.info("FileServiceImpl.uploadTaskChildPhoto:重新上传作业图片成功");

            TaskChild taskChild = taskChildService.selectTaskChild(childId, taskId);

            if (taskChild != null){
                //更新 TaskChild 的属性
                taskChild.setHomeworkPhoto("http://47.116.65.252:9000/taskchild/"+objectName);
                taskChild.setTaskApproveTime(null);
                taskChild.setComments(null);

                //update 方法一般接受两个参数：要更新的实体对象和一个 UpdateWrapper 对象，它允许你指定更新的条件。对于联合主键的情况，
                //可以使用 UpdateWrapper 中的 eq 方法来设置多个条件。
                UpdateWrapper<TaskChild> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("child_id", childId).eq("task_id", taskId);

                //rows为受影响的行数
                int rows = taskChildMapper.update(taskChild, updateWrapper);

                if (rows == 1) {
                    Runtimelogger.info("FileServiceImpl.uploadTaskChildPhotoAgain: 更新作业图片路径成功");
                } else {
                    Runtimelogger.error("FileServiceImpl.uploadTaskChildPhotoAgain: 更新作业图片路径失败");
                }

                return rows;
            }

            return -1;
        }
    }
}
