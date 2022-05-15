package com.feng.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: feng
 * @DateTime: 2022/5/15 22:42
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
