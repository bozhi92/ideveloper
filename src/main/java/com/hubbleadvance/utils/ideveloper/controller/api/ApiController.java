package com.hubbleadvance.utils.ideveloper.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubbleadvance.utils.ideveloper.controller.BaseController;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.domain.api.Api;
import com.hubbleadvance.utils.ideveloper.service.api.IApiService;

public class ApiController extends BaseController {
    @Autowired
    private IApiService apiService;
    
    @RequestMapping(value="/save")
    @ResponseBody
    public JsonResult save(@RequestBody @Validated Api api, HttpServletRequest req, BindingResult bindingResult) {
        api.setUid(getCurrentLoginUserId(req));
        JsonResult result = validate(bindingResult);
        return result != null ? result : apiService.add(api);
    }
    
    @RequestMapping(value="/update")
    @ResponseBody
    public JsonResult update(@RequestBody @Validated Api api, HttpServletRequest req, BindingResult bindingResult) {
        api.setUid(getCurrentLoginUserId(req));
        JsonResult result = validate(bindingResult);
        return result != null ? result : apiService.add(api);
    }
}
