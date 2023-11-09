package com.neu.administrator.service;

import com.neu.administrator.model.dto.MediaFilesDto;
import com.neu.base.model.RestResponse;

//文件上传服务
public interface FileService {

    //上传文件
    public boolean uploadFile( MediaFilesDto uploadFileParams, String localFilePath,String taskId);


}
