package com.feng.oss.controller;

import com.feng.oss.service.OssService;
import com.feng.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: feng
 * @DateTime: 2022/5/15 22:41
 */
@RestController
@RequestMapping("/oss/fileoss")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("/upload")
    public JsonResult uploadOssFile(MultipartFile file) {

        String url = ossService.uploadFileAvatar(file);
        return JsonResult.success().add("url", url);
    }
}
