package com.feng.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.edu.entity.Teacher;
import com.feng.edu.entity.vo.TeacherVo;
import com.feng.edu.service.TeacherService;
import com.feng.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public JsonResult findAllTeacher() {
        List<Teacher> list = teacherService.list(null);
        return JsonResult.success().add("list", list);
    }

    @DeleteMapping("/del")
    public boolean deleteTeacher(String id) {
        boolean flag = teacherService.removeById(id);
        return flag;
    }

    @GetMapping("/list/{current}/{limit}")
    public JsonResult pageList(@PathVariable long current, @PathVariable long limit) {
        Page<Teacher> page = new Page<Teacher>(current, limit);
        teacherService.page(page, null);
        long total = page.getTotal();
        List<Teacher> records = page.getRecords();
        return JsonResult.success().add("total", total).add("row", records);
    }

    @PostMapping("/queryData/{current}/{limit}")
    public JsonResult queryData(@PathVariable long current,
                                @PathVariable long limit,
                                @RequestBody(required = false) TeacherVo teacherVo) {
        //创建page对象
        Page<Teacher> page = new Page<Teacher>(current, limit);
        //构建条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<Teacher>();
        String name = teacherVo.getName();
        Integer level = teacherVo.getLevel();
        String begin = teacherVo.getBegin();
        String end = teacherVo.getEnd();

        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (level != null) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);
        }


        teacherService.page(page, wrapper);
        long total = page.getTotal();
        List<Teacher> records = page.getRecords();
        return JsonResult.success().add("total", total).add("row", records);
    }

    @PostMapping("/add")
    public JsonResult add(@RequestBody Teacher teacher) {

        teacher.setGmtCreate(new Date());
        teacher.setGmtModified(new Date());

        boolean save = teacherService.save(teacher);
        if (save) {
            return JsonResult.success("添加成功！").add("vo", teacher);
        } else {
            return JsonResult.failure("添加失败！");
        }
    }

    @GetMapping("/getById/{id}")
    public JsonResult getById(@PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return JsonResult.success("添加成功！").add("vo", teacher);
    }

    @PostMapping("/update")
    public JsonResult update(@RequestBody Teacher teacher) {

        teacher.setGmtModified(new Date());

        boolean save = teacherService.updateById(teacher);
        if (save) {
            return JsonResult.success("修改成功！").add("vo", teacher);
        } else {
            return JsonResult.failure("修改失败！");
        }
    }
}

