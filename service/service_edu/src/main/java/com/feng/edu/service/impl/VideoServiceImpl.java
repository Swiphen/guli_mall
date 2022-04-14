package com.feng.edu.service.impl;

import com.feng.edu.entity.Video;
import com.feng.edu.mapper.VideoMapper;
import com.feng.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author feng
 * @since 2022-04-14
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
