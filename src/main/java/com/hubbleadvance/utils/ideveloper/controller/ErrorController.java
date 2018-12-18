//package com.hubbleadvance.utils.ideveloper.controller;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.context.request.WebRequest;
//
//import com.alibaba.fastjson.JSON;
//
//@Controller
//@RequestMapping(value="/error")
//public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
//    @Autowired
//    private ErrorAttributes errorAttributes;
//    
//    @Override
//    public String getErrorPath() {
//        return null;
//    }
//    
//    @RequestMapping(value="")
//    @ResponseBody
//    public String error(HttpServletRequest req) {
//
//        return JSON.toJSONString(getErrorAttributes(req, true));
//    }
//    
//    private Map<String, Object> getErrorAttributes(HttpServletRequest req, boolean includeStackTrace) {
//        RequestAttributes requestAttributes = new ServletRequestAttributes(req);
//        errorAttributes.getErrorAttributes((WebRequest) requestAttributes, includeStackTrace);
//        return null;
//    }
//}
