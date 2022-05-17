package com.feng.exception;

/**
 * @Author: feng
 * @DateTime: 2022/5/2 1:51
 */
public class CommonException extends RuntimeException {
    private Integer code;
    private String msg;

    public CommonException() {
    }

    public CommonException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
