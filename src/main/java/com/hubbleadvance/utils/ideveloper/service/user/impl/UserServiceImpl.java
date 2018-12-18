package com.hubbleadvance.utils.ideveloper.service.user.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubbleadvance.utils.ideveloper.common.enums.JsonResultCodeEnum;
import com.hubbleadvance.utils.ideveloper.common.session.HttpSessionHelper;
import com.hubbleadvance.utils.ideveloper.common.session.OnlineUser;
import com.hubbleadvance.utils.ideveloper.common.session.OnlineUserManager;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.controller.login.param.LoginParam;
import com.hubbleadvance.utils.ideveloper.dao.user.IUserDao;
import com.hubbleadvance.utils.ideveloper.domain.user.User;
import com.hubbleadvance.utils.ideveloper.service.user.IUserService;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    
    @Override
    public JsonResult login(LoginParam param, HttpServletRequest req) {
        if (StringUtils.isNotEmpty(param.getAbc()) && StringUtils.isNotEmpty(param.getDef())) {
            User u = userDao.getByUname(param.getAbc());
            if (u != null) {
                if (u.getPwd().equals(param.getDef())) {
                    HttpSessionHelper.setCurrentLoginUser(req, u);
                    OnlineUser ou = new OnlineUser(u);
                    ou.setLoginTime(new Date().getTime());
                    ou.setIp(req.getRemoteAddr());
                    OnlineUserManager.addOnlineUser(ou);
                    return JsonResultCodeEnum.SUCCESS.buildResult(u);
                }
            }
        }
        return null;
    }

    @Override
    public JsonResult logout(HttpServletRequest req) {
        HttpSessionHelper.removeCurrentLoginUser(req);
        return JsonResultCodeEnum.SUCCESS.buildResult();
    }

    @Override
    public User get(String id) {
        return userDao.get(id);
    }
    


}
