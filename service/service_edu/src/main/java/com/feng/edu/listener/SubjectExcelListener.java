package com.feng.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.edu.entity.Subject;
import com.feng.edu.entity.vo.SubjectVo;
import com.feng.edu.service.SubjectService;
import com.feng.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: feng
 * @DateTime: 2022/5/17 22:12
 */
@Component
public class SubjectExcelListener extends AnalysisEventListener {

    @Autowired
    private SubjectService subjectService;

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        SubjectVo subjectVo = (SubjectVo) o;
        if (subjectVo == null) {
            throw new CommonException(20001, "文件数据为空");
        }
        //判断一级分类是否为空
        QueryWrapper<Subject> wrapper = new QueryWrapper<Subject>();
        wrapper.eq("title", subjectVo.getOneSubjectName());
        wrapper.eq("parent_id", "0");
        Subject subject = subjectService.getOne(wrapper);
        if (subject == null) {
            subject = new Subject();
            subject.setTitle(subjectVo.getOneSubjectName());
            subject.setParentId("0");
            subject.setGmtCreate(new Date());
            subject.setGmtModified(new Date());
            subjectService.save(subject);
        }

        String pid = subject.getId();

        //判断二级分类是否为空
        QueryWrapper<Subject> wrapper2 = new QueryWrapper<Subject>();
        wrapper2.eq("title", subjectVo.getTowSubjectName());
        wrapper2.eq("parent_id", pid);
        Subject subject2 = subjectService.getOne(wrapper2);
        if (subject2 == null) {
            subject2 = new Subject();
            subject2.setTitle(subjectVo.getTowSubjectName());
            subject2.setParentId(pid);
            subject2.setGmtModified(new Date());
            subject2.setGmtCreate(new Date());
            subjectService.save(subject2);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
