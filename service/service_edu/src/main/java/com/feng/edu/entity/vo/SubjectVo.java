package com.feng.edu.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author: feng
 * @DateTime: 2022/5/17 22:05
 */
@Data
public class SubjectVo {
    @ExcelProperty(index = 0)
    private String oneSubjectName;
    @ExcelProperty(index = 1)
    private String towSubjectName;
}
