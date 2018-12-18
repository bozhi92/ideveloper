package com.hubbleadvance.utils.ideveloper.controller.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubbleadvance.utils.ideveloper.common.enums.JsonResultCodeEnum;
import com.hubbleadvance.utils.ideveloper.common.utils.RequestUtil;
import com.hubbleadvance.utils.ideveloper.controller.BaseController;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.controller.PageParam;
import com.hubbleadvance.utils.ideveloper.domain.demo.Demo;
import com.hubbleadvance.utils.ideveloper.service.demo.IDemoService;

@Controller
@RequestMapping(value="/demo")
public class DemoController extends BaseController {
    @Autowired
    private IDemoService demoService;
    
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String list(HttpServletRequest req, Model model) {  
        model.addAttribute("pageList", demoService.list(new PageParam()));
        return "demo/list";
    }
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(HttpServletRequest req, Model model) {  
        return "demo/add";
    }
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(HttpServletRequest req, @PathVariable String id, Model model) {  
        JsonResult validateResult = validateId(id);
        if (validateResult != null) {
            return "error/400";
        }
        Demo demo = demoService.get(id);
        if (demo == null) {
            return "error/400";
        }
        model.addAttribute("demo", demo);
        return "demo/edit";
    }
    
    @RequestMapping(value="/list", method = RequestMethod.POST)
    public @ResponseBody JsonResult ajaxList(HttpServletRequest req, @RequestBody @Validated PageParam page, BindingResult bindingResult) {
        JsonResult validateResult = validate(bindingResult);
        if (!RequestUtil.isAjax(req)) {
            return JsonResultCodeEnum.REQUEST_ERROR.buildResult();
        }
        return validateResult == null ? success(demoService.list(page)) : validateResult;        
    }

    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public @ResponseBody JsonResult save(HttpServletRequest req, @RequestBody @Validated Demo demo, BindingResult bindingResult) {
        if (!RequestUtil.isAjax(req)) {
            return JsonResultCodeEnum.REQUEST_ERROR.buildResult();
        }
        JsonResult validateResult = validate(bindingResult);
        if (validateResult != null) {
            return validateResult;
        }
        if (demoService.save(demo)) {
            return success();
        }
        return error();
    }
    
    @RequestMapping(value="/remove", method = RequestMethod.POST)
    public @ResponseBody JsonResult remove(HttpServletRequest req, @RequestBody List<String> ids) {
        if (!RequestUtil.isAjax(req)) {
            return JsonResultCodeEnum.REQUEST_ERROR.buildResult();
        }
        JsonResult validateResult = validateId(ids);
        if (validateResult != null) {
            return validateResult;
        }
        if (demoService.batchRemove(ids)) {
            return success();
        }
        return error();
    }
    
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public @ResponseBody JsonResult update(HttpServletRequest req, @RequestBody @Validated Demo demo, BindingResult bindingResult) {
        if (!RequestUtil.isAjax(req)) {
            return JsonResultCodeEnum.REQUEST_ERROR.buildResult();
        }
        JsonResult validateResult = validate(bindingResult);
        if (validateResult != null) {
            return validateResult;
        }
        if (demoService.update(demo)) {
            return success();
        }
        return error();
    }
}
