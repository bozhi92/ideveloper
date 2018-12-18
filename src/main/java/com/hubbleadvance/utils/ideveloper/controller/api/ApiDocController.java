package com.hubbleadvance.utils.ideveloper.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubbleadvance.utils.ideveloper.controller.BaseController;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.domain.api.ApiDoc;
import com.hubbleadvance.utils.ideveloper.service.api.IApiDocService;
@Controller
@RequestMapping(value="/api/doc")
public class ApiDocController extends BaseController {
    @Autowired
    private IApiDocService apiDocService;
    
    @RequestMapping(value="/save")
    @ResponseBody
    public JsonResult save(@RequestBody @Validated ApiDoc apiDoc, HttpServletRequest req, BindingResult bindingResult) {
        apiDoc.setUid(getCurrentLoginUserId(req));
        JsonResult result = validate(bindingResult);
        return result != null ? result : apiDocService.add(apiDoc);
    }
    
    @RequestMapping(value="/update")
    @ResponseBody
    public JsonResult update(@RequestBody @Validated ApiDoc apiDoc, HttpServletRequest req, BindingResult bindingResult) {
        apiDoc.setUid(getCurrentLoginUserId(req));
        JsonResult result = validate(bindingResult);
        return result != null ? result : apiDocService.add(apiDoc);
    }
    
    
}
