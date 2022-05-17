package com.feng.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.edu.entity.Subject;
import com.feng.edu.mapper.SubjectMapper;
import com.feng.edu.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author feng
 * @since 2022-04-14
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public void addSubject(MultipartFile file) {
        try {
            InputStream in = file.getInputStream();

//            EasyExcel.read(in, SubjectVo.class, new SubjectExcelListener()).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
