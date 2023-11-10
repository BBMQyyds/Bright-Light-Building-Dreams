package com.blbd.children.controller;

import com.blbd.children.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/8 - 21:29
 */

@Controller
@RestController
@RequestMapping("/children/file")
@Slf4j
//@Api(tags = "控制器-file")
public class FileController {
    private static final Logger Runtimelogger = LoggerFactory.getLogger("RuntimeLogger");

    @Autowired
    private FileService fileService;

    /**
     * 显示任务图片
     */
    @RequestMapping("/getTaskChildPhoto/{childId}/{taskId}")
    public ResponseEntity<Map<String,Object>> getTaskChildPhoto(@PathVariable String childId, @PathVariable String taskId,HttpServletResponse httpServletResponse){
        Map<String, Object> response = new HashMap<>();

        try {
            fileService.getTaskChildPhoto(childId, taskId, httpServletResponse);
            Runtimelogger.info("FileController.getTaskChildPhoto:获取作业图片成功");

            response.put("success", true);
            response.put("message", "作业图片显示成功");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            Runtimelogger.error("FileController.getTaskChildPhoto:获取作业图片失败");

            response.put("success", false);
            response.put("message", "作业图片显示失败或没有该图片");

            //返回 400 Bad Request 表示请求不合法.(待推敲哪个状态码更合适)
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 下载任务图片
     */
    @RequestMapping("/downloadTaskChildPhoto/{childId}/{taskId}")
    public ResponseEntity<Map<String,Object>> downloadTaskChildPhoto(@PathVariable String childId, @PathVariable String taskId,HttpServletResponse httpServletResponse){
        Map<String, Object> response = new HashMap<>();

        try {
            fileService.downloadTaskChildPhoto(childId, taskId, httpServletResponse);
            Runtimelogger.info("FileController.getTaskChildPhoto:获取作业图片成功");

            response.put("success", true);
            response.put("message", "作业图片显示成功");
            return ResponseEntity.ok(response);
        }catch (Exception e){
            Runtimelogger.error("FileController.getTaskChildPhoto:获取作业图片失败");

            response.put("success", false);
            response.put("message", "作业图片显示失败或没有该图片");

            //返回 400 Bad Request 表示请求不合法.(待推敲哪个状态码更合适)
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 提交作业图片/任务
     */
    @PostMapping("/uploadTaskChildPhoto")
    public ResponseEntity<Map<String,Object>> addTaskChild(@RequestParam String childId, @RequestParam String taskId, @RequestParam("file") MultipartFile file){
        Map<String, Object> response = new HashMap<>();
        int result = fileService.uploadTaskChildPhoto(childId, taskId, file);

        if (result == 1) {
            response.put("success", true);
            response.put("message", "作业图片上传成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "作业图片上传失败");

            //返回 400 Bad Request 表示请求不合法.(待推敲哪个状态码更合适)
            return ResponseEntity.badRequest().body(response);
        }
    }

    /*@PostMapping("/uploadTaskChildPhoto/{childId}/{taskId}")
    public ResponseEntity<Map<String,Object>> addTaskChild(@PathVariable String childId, @PathVariable String taskId, @RequestParam("file") MultipartFile file){
        Map<String, Object> response = new HashMap<>();
        int result = fileService.uploadTaskChildPhoto(childId, taskId, file);

        if (result == 1) {
            response.put("success", true);
            response.put("message", "作业图片上传成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "作业图片上传失败");

            //返回 400 Bad Request 表示请求不合法.(待推敲哪个状态码更合适)
            return ResponseEntity.badRequest().body(response);
        }
    }*/

    /**
     * 审批未通过重新提交任务
     * 修改task_child
     */
    @PostMapping("/uploadTaskChildPhotoAgain")
    public ResponseEntity<Map<String,Object>> updateTaskChild(@RequestParam String childId, @RequestParam String taskId, @RequestParam("file") MultipartFile file){
        Map<String, Object> response = new HashMap<>();
        int result = fileService.uploadTaskChildPhotoAgain(childId, taskId, file);

        if (result == 1) {
            response.put("success", true);
            response.put("message", "作业图片重新上传成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "作业图片重新上传失败");

            //返回 400 Bad Request 表示请求不合法.(待推敲哪个状态码更合适)
            return ResponseEntity.badRequest().body(response);
        }
    }
}
