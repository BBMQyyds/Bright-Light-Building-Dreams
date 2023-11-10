package com.blbd.children.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Date 2023/11/10 9:28
 * @Version 1.0
 */
@Data
public class ChatLink {
    private String linkId;
    private String senderId;
    private String receiverId;
    private Date creatTime;
}
