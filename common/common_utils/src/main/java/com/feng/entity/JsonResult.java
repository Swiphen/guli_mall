package com.feng.entity;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {


    private String code = null;

    private String message = null;

    private Map<String, Object> body = new HashMap();

    public JsonResult() {
    }

    public JsonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public JsonResult add(String key, Object value) {
        this.getBody().put(key, value);
        return this;
    }

    public static JsonResult failure() {
        JsonResult result = new JsonResult();
        result.setCode("failure");
        result.setMessage("处理失败！");
        return result;
    }

    public static JsonResult failure(String msg) {
        JsonResult result = new JsonResult();
        result.setCode("failure");
        if (msg != null && msg.length() > 0) {
            result.setMessage(msg);
        } else {
            result.setMessage("处理失败！");
        }

        return result;
    }

    public static JsonResult success() {
        JsonResult result = new JsonResult();
        result.setCode("success");
        result.setMessage("处理成功！");
        return result;
    }

    public static JsonResult success(String msg) {
        JsonResult result = new JsonResult();
        result.setCode("success");
        result.setMessage(msg);
        return result;
    }

}
