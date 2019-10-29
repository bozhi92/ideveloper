package com.hubbleadvance.utils.ideveloper.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubbleadvance.utils.ideveloper.controller.BaseController;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.controller.login.param.LoginParam;
import com.hubbleadvance.utils.ideveloper.service.user.IUserService;
@Controller
public class LoginController extends BaseController {
    @Autowired
    private IUserService userService;
//    @Autowired
//    private RedisTemplate redisTemplate;
    
    @RequestMapping(value="/login", method={RequestMethod.GET})
    public String loginPage(Model model) {
        model.addAttribute("test", "get");
        return "login";
    }
    @RequestMapping(value="/login", method={RequestMethod.POST})
    @ResponseBody
    public JsonResult login(@RequestBody LoginParam param, HttpServletRequest req) {
        //redisTemplate.opsForValue().set("test_login", JSON.toJSONString(param));
        return userService.login(param, req);
    }
    
    @RequestMapping(value="/logout", method={RequestMethod.POST})
    @ResponseBody
    public JsonResult logout(@RequestBody LoginParam param, HttpServletRequest req) {
        
        return userService.logout(req);
    }
}
