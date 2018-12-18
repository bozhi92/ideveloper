package com.hubbleadvance.utils.ideveloper.common.session;

import javax.servlet.http.HttpServletRequest;

import com.hubbleadvance.utils.ideveloper.domain.user.User;

public class HttpSessionHelper {
    public static User getCurrentLoginUser(HttpServletRequest req) {
        return (User)req.getSession().getAttribute("user_info");
    }
    
    public static void setCurrentLoginUser(HttpServletRequest req, User u) {
        req.getSession().setAttribute("user_info", u);
    }
    
    public static Object getAttribute(HttpServletRequest req, String k) {
        return req.getSession().getAttribute(k);
    }
    
    public static void setAttribute(HttpServletRequest req, String k, Object v) {
        req.getSession().setAttribute(k, v);
    }
    
    public static void removeCurrentLoginUser(HttpServletRequest req) {
        req.getSession().invalidate();
    }
    
    public static void setMaxInactiveInterval(HttpServletRequest req, int interval) {
        req.getSession().setMaxInactiveInterval(interval);
    }
}
