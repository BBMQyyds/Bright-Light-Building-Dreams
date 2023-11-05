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


    //以下是志愿者的
    /**
     * 交换机
     */
    public final static String VOL_EXCHANGE = "vol.topic";
    /**
     * 监听新增和修改的队列
     */
    public final static String VOL_INSERT_QUEUE = "vol.insert.queue";
    /**
     * 监听删除的队列
     */
    public final static String VOL_DELETE_QUEUE = "vol.delete.queue";

    /**
     * 新增或修改的RoutingKey
     */
    public final static String VOL_INSERT_KEY = "vol.insert";
    /**
     * 删除的RoutingKey
     */
    public final static String VOL_DELETE_KEY = "vol.delete";



    //以下是任务的
    /**
     * 布置任务的队列
     */
    public final static String TASK_VOL_ALLOCATE_QUEUE="task.vol.allocate.queue";
    /**
     *分配任务的RoutingKey
     */
    public final static String TASK_VOL_ALLOCATE_KEY="task.vol.allocate";
}
