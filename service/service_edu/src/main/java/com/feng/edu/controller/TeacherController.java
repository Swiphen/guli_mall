package com.feng.edu.controller;


import com.feng.edu.entity.Teacher;
import com.feng.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author feng
 * @since 2022-04-14
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/findAll")
    public List<Teacher> findAllTeacher() {
        List<Teacher> list = teacherService.list(null);

        return list;
    }

    @DeleteMapping("/del")
    public boolean deleteTeacher(String id) {
        boolean flag = teacherService.removeById(id);
        return flag;
    }
}

