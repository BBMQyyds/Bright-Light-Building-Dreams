package com.neu.administrator.model.po;

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
@TableName("chat_link")
public class ChatLink implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天关系表id
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
     * 创建时间
     */
    private LocalDateTime createTime;


}
