package com.feng.edu;

import com.feng.edu.entity.Teacher;
import com.feng.edu.mapper.TeacherMapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestApplication {
    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void main() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<Teacher> teachers = teacherMapper.selectList(null);
//        teachers.forEach(System.out::println);
    }

}
