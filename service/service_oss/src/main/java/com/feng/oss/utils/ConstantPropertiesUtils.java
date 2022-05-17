package com.feng.oss.utils;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: feng
 * @DateTime: 2022/5/15 22:25
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //读取配置文件内容
//    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    //    @Value("${aliyun.oss.file.keyid}")
    private String keyid;
    //    @Value("${aliyun.oss.file.keySecret}")
    private String keySecret;
    //    @Value("${aliyun.oss.file.bucketName}")
    private String bucketName;

    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        KEY_ID = keyid;
        KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}
