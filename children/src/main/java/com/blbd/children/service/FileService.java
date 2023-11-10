package com.blbd.children.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/8 - 21:33
 */
public interface FileService {
    /**
     * 显示当前孩子的作业图片
     */
    public void getTaskChildPhoto(String childId, String taskId,HttpServletResponse httpServletResponse);

    /**
     * 下载当前孩子的作业图片
     */
    public void downloadTaskChildPhoto(String childId, String taskId, HttpServletResponse httpServletResponse);

    /**
     * 上传当前孩子的作业图片
     */
    public int uploadTaskChildPhoto(String childId,String taskId, MultipartFile file);

    /**
     * 重新上传当前孩子的作业图片
     */
    public int uploadTaskChildPhotoAgain(String childId, String taskId, MultipartFile file);
}
