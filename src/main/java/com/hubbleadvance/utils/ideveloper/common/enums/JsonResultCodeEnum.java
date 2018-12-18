package com.hubbleadvance.utils.ideveloper.common.enums;

import com.hubbleadvance.utils.ideveloper.controller.JsonResult;

public enum JsonResultCodeEnum {
    SUCCESS("200", "请求成功"),
    ERROR("300", "错误"),
    UNAME_NOT_EXISTED("301", "用户名不存在"),
    PWD_ERROR("302", "密码错误"),
    NO_LOGIN_ERROR("303", "未登录"),
    LOGIN_TIME_OUT_ERROR("304", "登录超时"),
    PARAM_ERROR("320", "参数错误"),
    REQUEST_ERROR("330", "无效的请求"),
    NO_PERMISSION_ERROR("350", "没有权限");
    
    private String code;
    private String msg;
    
    JsonResultCodeEnum (String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public JsonResult buildResult() {
        JsonResult result = new JsonResult();
        result.setCode(this.code);
        result.setMsg(this.msg);
        return result;
    }
    
    public JsonResult buildResult(Object data) {
        JsonResult result = new JsonResult();
        result.setCode(this.code);
        result.setMsg(this.msg);
        result.setData(data);
        return result;
    }
}
