package com.neu.administrator.constants;

public class MqConstants {

    /**
     * 交换机
     */
    public final static String CHILD_EXCHANGE = "child.topic";
    /**
     * 监听新增和修改的队列
     */
    public final static String CHILD_INSERT_QUEUE = "child.insert.queue";
    /**
     * 监听删除的队列
     */
    public final static String CHILD_DELETE_QUEUE = "child.delete.queue";
    /**
     * 新增或修改的RoutingKey
     */
    public final static String CHILD_INSERT_KEY = "child.insert";
    /**
     * 删除的RoutingKey
     */
    public final static String CHILD_DELETE_KEY = "child.delete";
}
