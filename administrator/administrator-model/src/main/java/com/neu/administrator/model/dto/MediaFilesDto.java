package com.neu.administrator.model.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 媒资信息
 * </p>
 *
 * @author itcast
 */
@Data
@TableName("media_files")
public class MediaFilesDto implements Serializable {


    /**
     * 文件名称
     */
    private String filename;


    /**
     * 存储目录
     */
    private String bucket;

    /**
     * 存储路径
     */
    private String filePath;


    /**
     * 文件标识
     */
    private String fileId;

    /**
     * 媒资文件访问地址
     */
    private String url;







}
