package com.fh.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

public class OssFileUtils_zy {
    private static String endpoint="oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId="LTAI4GL2z2z4gbLsrtabY9ij";
    private static  String accessKeySecret = "Gi1J1eYIx3NEt2e7IVIBaWktyy7QlN";
    private static String bucket="dsimgpath";


    public static String uploadFile(InputStream is,String fileName){
        // 下载jar包
        //创建工具类
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //调用上传方法
        PutObjectResult putObjectResult = ossClient.putObject(bucket, fileName, is);
        //判断是否上传成功
        //释放资源
        ossClient.shutdown();
        //返回文件的存储路径
                //创建的名称    地区                      图片名称
        //https://dsimgpath.oss-cn-beijing.aliyuncs.com/213312-1558704792daa4.jpg
        return "https://"+bucket+"."+endpoint+"/"+fileName;
    }


}
