package com.hubbleadvance.utils.ideveloper.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.alibaba.fastjson.JSON;
import com.hubbleadvance.utils.ideveloper.common.enums.JsonResultCodeEnum;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;

public class ValidUtils {
    public static JsonResult validate(BindingResult bindingResult) {
        JsonResult jsonResult = null;
        if (bindingResult.hasErrors()) {
            List<String> erroMessages = new ArrayList<String>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                erroMessages.add(fieldError.getDefaultMessage());
            }
            jsonResult = new JsonResult();
            jsonResult.setCode(JsonResultCodeEnum.PARAM_ERROR.getCode());
            jsonResult.setMsg(JSON.toJSONString(erroMessages));
        }
        return jsonResult;
    }
    
    public static JsonResult validateId(List<String> ids) {
        JsonResult jsonResult = null;
        List<String> list = null;
        for (String id : ids) {
            if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)|| id.length() != 18) {
                if (list == null) {
                    list = new ArrayList<String>();
                }
                list.add("无效的id:\'"+id+"\'");
            }
        }
        if (list != null) {
            jsonResult = new JsonResult();
            jsonResult.setCode(JsonResultCodeEnum.PARAM_ERROR.getCode());
            jsonResult.setMsg(JSON.toJSONString(list));         
        }
        return jsonResult;
    }
    
    public static JsonResult validateId(String id) {
        JsonResult jsonResult = null;
        if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)|| id.length() != 18) {
            jsonResult = new JsonResult();
            jsonResult.setCode(JsonResultCodeEnum.PARAM_ERROR.getCode());
            jsonResult.setMsg(JSON.toJSONString("无效的id:\'"+id+"\'"));
        }
        return jsonResult;
    }
}
