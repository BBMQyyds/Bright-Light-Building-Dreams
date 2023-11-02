package com.blbd.children.beans;

import org.springframework.stereotype.Repository;

/**
 * @Author Zang Xinrui
 * @Description TODO
 * @Version 1.0
 */
@Repository
public class HttpResponseEntity {
    private String code;//状态码
    private Object data;//数据
    private String message;//消息

    public HttpResponseEntity() {
    }

    public HttpResponseEntity(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    @Override
    public String toString() {
        return "HttpResponseEntity{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
