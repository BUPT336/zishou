package com.marfei.site.model;

/**
 * @author Litch1
 * @date 2021/5/5 6:44 下午
 */
public class Response {
    public int code;
    public Object data;

    public Response(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
