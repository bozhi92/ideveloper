package com.hubbleadvance.utils.ideveloper.common.utils;

import javax.servlet.http.HttpServletRequest;

public final class RequestUtil {
    
    public static boolean isAjax(HttpServletRequest req) {
        return req.getHeader("x-requested-with") != null && "XMLHttpRequest".equalsIgnoreCase(req.getHeader("x-requested-with"));
    }

}
