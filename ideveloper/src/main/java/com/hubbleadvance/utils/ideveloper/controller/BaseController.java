package com.hubbleadvance.utils.ideveloper.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

import com.hubbleadvance.utils.ideveloper.common.enums.JsonResultCodeEnum;
import com.hubbleadvance.utils.ideveloper.common.session.HttpSessionHelper;
import com.hubbleadvance.utils.ideveloper.common.utils.ValidUtils;
import com.hubbleadvance.utils.ideveloper.domain.user.User;

public class BaseController {
    public JsonResult success() {
        return JsonResultCodeEnum.SUCCESS.buildResult();
    }
    
    public JsonResult success(Object data) {
        return JsonResultCodeEnum.SUCCESS.buildResult(data);
    }
    
    public JsonResult error() {
        return JsonResultCodeEnum.ERROR.buildResult();
    }
    
    public JsonResult validate(BindingResult bindingResult) {
        return ValidUtils.validate(bindingResult);
    }
    
    public JsonResult validateId(List<String> ids) {
        return ValidUtils.validateId(ids);
    }
    
    public JsonResult validateId(String id) {
        return ValidUtils.validateId(id);
    }
    
    public User getCurrentLoginUser(HttpServletRequest req) {
        return HttpSessionHelper.getCurrentLoginUser(req);
    }
    
    public String getCurrentLoginUserId(HttpServletRequest req) {
        return getCurrentLoginUser(req).getId();
    }
}
