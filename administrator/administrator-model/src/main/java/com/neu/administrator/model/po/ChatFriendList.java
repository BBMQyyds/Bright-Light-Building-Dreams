package com.neu.administrator.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zzm
 */
@Data
@TableName("chat_friend_list")
public class ChatFriendList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天列表主键
     */
    @TableId(value = "list_id", type = IdType.AUTO)
    private Integer listId;

    /**
     * 聊天主表id
     */
    private String linkId;

    /**
     * 发送者
     */
    private String senderId;

    /**
     * 接收者
     */
    private String receiverId;

    /**
     * 接收者头像
     */
    private String receiverPicture;

    /**
     * 发送方是否在窗口
     */
    private Integer senderIsOnline;

    /**
     * 接收方是否在窗口
     */
    private Integer receiverIsOnline;

    /**
     * 未读数
     */
    private Integer unread;

    /**
     * 是否删除
     */
    private Integer status;


}
