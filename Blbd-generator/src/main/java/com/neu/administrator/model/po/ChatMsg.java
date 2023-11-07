package com.neu.administrator.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzm
 */
@Data
@TableName("chat_msg")
public class ChatMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天内容id
     */
    @TableId(value = "message_id", type = IdType.AUTO)
    private Integer messageId;

    /**
     * 聊天主表id
     */
    private String linkId;

    /**
     * 消息类型
     */
    private Integer msgType;

    /**
     * 发送者
     */
    private String senderId;

    /**
     * 接收者
     */
    private String receiverId;

    /**
     * 聊天内容
     */
    private String msgBody;

    /**
     * 发送时间
     */
    private LocalDateTime sendTime;

    /**
     * 是否为最后一条信息
     */
    private Integer isLatest;


}
