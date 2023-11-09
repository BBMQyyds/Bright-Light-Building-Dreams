package com.neu.administrator.service.impl;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;
import com.neu.administrator.mapper.TaskMapper;
import com.neu.administrator.model.dto.MediaFilesDto;
import com.neu.administrator.model.po.Task;
import com.neu.administrator.service.FileService;
import com.neu.base.exception.BlbdException;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    MinioClient minioClient;

    @Value("${minio.bucket.photofiles}")
    private String bucket_Files;

    @Value("${minio.bucket.videofiles}")
    private String bucket_VideoFiles;

    @Autowired
    private TaskMapper taskMapper;

    public static final String minioUrl="http://123.56.248.217:9000/";


    //获取文件默认存储目录路径 年/月/日
    private String getDefaultFolderPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String folder = sdf.format(new Date()).replace("-", "/")+"/";
        return folder;
    }

    //获取文件的md5
    private String getFileMd5(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            String fileMd5 = DigestUtils.md5Hex(fileInputStream);
            return fileMd5;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取文件的媒体类型
    private String getMimeType(String extension){
        if(extension==null)
            extension = "";
        //根据扩展名取出mimeType
        ContentInfo extensionMatch = ContentInfoUtil.findExtensionMatch(extension);
        //通用mimeType，字节流
        String mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        if(extensionMatch!=null){
            mimeType = extensionMatch.getMimeType();
        }
        return mimeType;
    }


    /**
     * @description 将文件写入minIO
     * @param localFilePath  文件地址
     * @param bucket  桶
     * @param objectName 对象名称
     */
    public boolean addMediaFilesToMinIO(String localFilePath,String mimeType,String bucket, String objectName) {
        try {
            UploadObjectArgs testbucket = UploadObjectArgs.builder()
                    .bucket(bucket)
                    .object(objectName)//放到minio中的文件名
                    .filename(localFilePath)//本地文件路径
                    .contentType(mimeType)
                    .build();
            minioClient.uploadObject(testbucket);
            log.debug("上传文件到minio成功,bucket:{},objectName:{}",bucket,objectName);
            System.out.println("上传成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传文件到minio出错,bucket:{},objectName:{},错误原因:{}",bucket,objectName,e.getMessage(),e);
            BlbdException.cast("上传文件到文件系统失败");
        }
        return false;
    }


    /**
     * @description 将文件路径信息添加到任务表
     * @param bucket  桶
     * @param objectName 对象名称
     */
    public void addMediaFilesToDb(String bucket, String objectName,String taskId){
        //从数据库查询任务
        Task task=taskMapper.selectById(taskId);
        String url=minioUrl+bucket+"/"+objectName;
        if(bucket.equals(bucket_Files))
            //设置任务图片路径
            task.setTaskPhoto(url);
        else{
            //设置任务视频路径
            task.setVideo(url);
        }
        taskMapper.updateById(task);

    }


    public boolean uploadFile( MediaFilesDto mediaFilesDto, String localFilePath,String taskId) {

        File file = new File(localFilePath);
        if (!file.exists()) {
            BlbdException.cast("文件不存在");
        }
        //文件名称
        String filename = mediaFilesDto.getFilename();
        //文件扩展名
        String extension = filename.substring(filename.lastIndexOf("."));
        //文件mimeType
        String mimeType = getMimeType(extension);
        //文件的md5值
        String fileMd5 = getFileMd5(file);
        //文件的默认目录,按年月日存储
        String defaultFolderPath = getDefaultFolderPath();
        //存储到minio中的对象名(fileMd5.extension是存储在目录里的对象名称)
        String  objectName = defaultFolderPath + fileMd5 + extension;
        log.info(extension);
        log.info(mimeType);
        if(!extension.equals(".mp4")){
            //将文件上传到minio
            boolean b = addMediaFilesToMinIO(localFilePath, mimeType, bucket_Files, objectName);
            //将文件信息存储到数据库
            addMediaFilesToDb(bucket_Files, objectName,taskId);
            if(b){
                return true;
            }
            return false;
        }
        else {
            //将文件上传到minio
            boolean b = addMediaFilesToMinIO(localFilePath, mimeType, bucket_VideoFiles, objectName);
            //将文件信息存储到数据库
            addMediaFilesToDb(bucket_VideoFiles, objectName,taskId);
            if(b){
                return true;
            }
            return false;
        }

    }

}
