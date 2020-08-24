package com.qx.model.base;

public class Result<T>extends Page {

    public static Integer code_success = 0;
    public static Integer code_failed=1;
    public static String msg_success = "success";
    public static String msg_failed = "failed";

    private T data;
    private Integer code;
    private String msg;
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}