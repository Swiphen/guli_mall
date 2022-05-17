package com.feng.edu.service;

import com.feng.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author feng
 * @since 2022-04-14
 */
public interface SubjectService extends IService<Subject> {

    void addSubject(MultipartFile file);
}
