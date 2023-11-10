package com.blbd.children.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blbd.children.dao.dto.VideoCallDTO;
import com.blbd.children.mapper.VideoCallMapper;
import com.blbd.children.service.VideoCallService;
import org.springframework.stereotype.Service;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/10 9:34
 * @Version 1.0
 */
@Service
public class VideoCallServiceImpl extends ServiceImpl<VideoCallMapper, VideoCallDTO> implements VideoCallService {

    @Override
    public long count() {
        return VideoCallService.super.count();
    }
}
