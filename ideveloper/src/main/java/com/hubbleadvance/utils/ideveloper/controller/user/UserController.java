package com.hubbleadvance.utils.ideveloper.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubbleadvance.utils.ideveloper.common.session.OnlineUserManager;
import com.hubbleadvance.utils.ideveloper.controller.BaseController;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
@Controller
public class UserController extends BaseController{
    @RequestMapping(value="/onlineUser")
    @ResponseBody
    public JsonResult onlineUser() {
        
        return success(OnlineUserManager.getOnlineUserList());
    }
}
