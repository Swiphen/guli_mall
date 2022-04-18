package com.feng.edu.mapper;

import com.feng.edu.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2022-04-14
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
