package com.hubbleadvance.utils.ideveloper.service.user;

import javax.servlet.http.HttpServletRequest;

import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.controller.login.param.LoginParam;
import com.hubbleadvance.utils.ideveloper.domain.user.User;

public interface IUserService {
    JsonResult login(LoginParam param, HttpServletRequest req);
    JsonResult logout(HttpServletRequest req);
    
    
    
    User get(String id);
}
