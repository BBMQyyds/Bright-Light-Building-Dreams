package com.blbd.children.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blbd.children.dao.entity.ChatLink;
import com.blbd.children.mapper.ChatLinkMapper;
import com.blbd.children.service.ChatLinkService;
import org.springframework.stereotype.Service;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/10 9:34
 * @Version 1.0
 */
@Service
public class ChatLinkServiceImpl extends ServiceImpl<ChatLinkMapper, ChatLink> implements ChatLinkService {

    @Override
    public long count() {
        return ChatLinkService.super.count();
    }
}
