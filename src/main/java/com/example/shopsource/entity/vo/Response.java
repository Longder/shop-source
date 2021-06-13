package com.example.shopsource.entity.vo;

import lombok.Data;

/**
 * 返回结果对象
 */
@Data
public class Response {

    /**
     * 返回状态
     */
    private boolean success;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回状态码
     */
    private String code;

    /**
     * 返回对象
     */
    private Object data;

    public Response(){}

    public Response(boolean success, String code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Response success() {
        return new Response(true, "0", "", null);
    }

    public static Response success(String msg) {
        return new Response(true, "0", msg, null);
    }

    public static Response success(Object data) {
        return new Response(true, "0", "", data);
    }

    public static Response success(String msg, Object data) {
        return new Response(true, "0", msg, data);
    }

    public static Response error(String msg) {
        return new Response(false, "1", msg, null);
    }

    public static Response error(String msg, Object data) {
        return new Response(false, "1", msg, data);
    }
}
