package com.hubbleadvance.utils.ideveloper.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hubbleadvance.utils.ideveloper.common.enums.JsonResultCodeEnum;
import com.hubbleadvance.utils.ideveloper.common.enums.UserRoleEnum;
import com.hubbleadvance.utils.ideveloper.common.session.HttpSessionHelper;
import com.hubbleadvance.utils.ideveloper.common.utils.RequestUtil;
import com.hubbleadvance.utils.ideveloper.common.utils.ResponseUtil;
import com.hubbleadvance.utils.ideveloper.domain.user.User;
import com.hubbleadvance.utils.ideveloper.service.function.IFunctionGroupService;
import com.hubbleadvance.utils.ideveloper.service.function.IFunctionService;
@Component
public class PermissionInterceptor implements HandlerInterceptor {
//    @Autowired
//    private IFunctionGroupService functionGroupService;
//    @Autowired
//    private IFunctionService functionService;
    
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        User u = HttpSessionHelper.getCurrentLoginUser(req);
        if (permission(u, req)) {
            return true;
        }
        if (RequestUtil.isAjax(req)) {
            ResponseUtil.returnJsonResult(res, JsonResultCodeEnum.NO_PERMISSION_ERROR.buildResult());
        } else {
            res.sendRedirect(req.getContextPath() + "/403");
        }
        return false;
        
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
        
    private boolean permission(User u, HttpServletRequest req) {
        if ((u.getRole() & UserRoleEnum.CREATOR.getKey()) > 0) {
            return true;
        } else {
           // if (functionGroupService.isExistedByGroup("", ""));
        }
        return true;
    }
}
