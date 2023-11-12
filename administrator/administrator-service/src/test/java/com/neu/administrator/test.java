//package com.neu.administrator;
//
//import com.j256.simplemagic.ContentInfo;
//import com.j256.simplemagic.ContentInfoUtil;
//import io.minio.GetObjectArgs;
//import io.minio.MinioClient;
//import io.minio.RemoveObjectArgs;
//import io.minio.UploadObjectArgs;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.compress.utils.IOUtils;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.MediaType;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FilterInputStream;
//
//public class test {
//
//    static MinioClient minioClient =
//            MinioClient.builder()
//                    .endpoint("http://123.56.248.217:9000")
//                    .credentials("minioadmin", "minioadmin")
//                    .build();
//
//
//    //上传文件
//    @Test
//    public  void upload() {
//        //根据扩展名取出mimeType
//        ContentInfo extensionMatch = ContentInfoUtil.findExtensionMatch(".jpg");
//        String mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;//通用mimeType，字节流
//        if(extensionMatch!=null){
//            mimeType = extensionMatch.getMimeType();
//        }
//        try {
//            UploadObjectArgs testbucket = UploadObjectArgs.builder()
//                    .bucket("photos")
////                    .object("test001.mp4")
//                    .object("001/lovezjs.jpg")//添加子目录
//                    .filename("D:\\develop\\upload\\1.jpg")
//                    .contentType(mimeType)//默认根据扩展名确定文件内容类型，也可以指定
//                    .build();
//            minioClient.uploadObject(testbucket);
//            System.out.println("上传成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("上传失败");
//        }
//    }
//
//    @Test
//    public void uploadto(){
//
//    }
//
//    @Test
//    public void delete(){
//        try {
//            minioClient.removeObject(
//                    RemoveObjectArgs.builder().bucket("photo").object("001/lovezjs.mp4").build());
//            System.out.println("删除成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("删除失败");
//        }
//    }
//
//    //查询文件
//    @Test
//    public void getFile() {
//        GetObjectArgs getObjectArgs = GetObjectArgs.builder().bucket("testbucket").object("001/test1.mp4").build();
//
//        try (
//                FilterInputStream inputStream = minioClient.getObject(getObjectArgs);//从文件系统拿输入流，是一个远程的流，通过网络获取数据，不要传输远程流
//                FileOutputStream outputStream = new FileOutputStream(new File("D:\\develop\\upload\\local1.mp4"));//下载到本地需要输入流
//        ) {
//            IOUtils.copy(inputStream, outputStream);//流拷贝，输入流考入到输出流里
//
//            //校验下载下来的文件的完整性，上传也需要,注意MD5引用的是apache的包
//            //对文件的内容进行md5得到摘要串，然后和minio中存储的文件的摘要串进行比较，看值是否相等
////            FileInputStream fileInputStream1 = new FileInputStream(new File("D:\\develop\\upload\\1.mp4"));
////            String source_md5 = DigestUtils.md5Hex(inputStream);//minio中的文件的md5
//            FileInputStream fileInputStream1 = new FileInputStream(new File("D:\\develop\\upload\\1.mp4"));
//            String source_md5 = DigestUtils.md5Hex(fileInputStream1);//比较硬盘上的文件1和从minio中下载到本地的文件local1.mp4的md5值，而不去对比远程流inputStream
//            FileInputStream fileInputStream = new FileInputStream(new File("D:\\develop\\upload\\local1.mp4"));
//            String local_md5 = DigestUtils.md5Hex(fileInputStream);
//            if (source_md5.equals(local_md5)) {
//                System.out.println("下载成功");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//}
