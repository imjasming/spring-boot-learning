package com.xiaoming.springbootlearning.domain;

/**
 * @author Xiaoming.
 * Created on 2019/03/11 00:15.
 * Description :
 */
public class CommonRestResponse {
    private boolean status;
    private int code;
    private String message;
    private Object data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
