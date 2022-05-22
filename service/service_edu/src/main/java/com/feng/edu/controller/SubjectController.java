package com.feng.edu.controller;


import com.feng.edu.service.SubjectService;
import com.feng.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author feng
 * @since 2022-04-14
 */
@RestController
@RequestMapping("/edu/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    //添加课程分类
    @PostMapping("/addSubject")
    public JsonResult addSubject(MultipartFile file) {
        subjectService.addSubject(file);
        return JsonResult.success();
    }
}

