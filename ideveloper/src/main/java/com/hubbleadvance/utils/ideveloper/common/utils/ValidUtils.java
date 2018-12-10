package com.hubbleadvance.utils.ideveloper.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.alibaba.fastjson.JSON;
import com.hubbleadvance.utils.ideveloper.common.enums.JsonResultCodeEnum;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;

public class ValidUtils {
    public static JsonResult validate(BindingResult bindingResult) {
        JsonResult jsonResult = null;
        if (bindingResult.hasErrors()) {
            List<String >erroMessages=new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                erroMessages.add(fieldError.getDefaultMessage());
            }
            jsonResult = new JsonResult();
            jsonResult.setCode(JsonResultCodeEnum.PARAM_ERROR.getCode());
            jsonResult.setMsg(JSON.toJSONString(erroMessages));
        }
        return jsonResult;

    }
}
