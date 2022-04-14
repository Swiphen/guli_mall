package com.feng.edu.service.impl;

import com.feng.edu.entity.Comment;
import com.feng.edu.mapper.CommentMapper;
import com.feng.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author feng
 * @since 2022-04-14
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
