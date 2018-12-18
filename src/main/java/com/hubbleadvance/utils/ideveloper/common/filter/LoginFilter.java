package com.hubbleadvance.utils.ideveloper.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hubbleadvance.utils.ideveloper.common.enums.JsonResultCodeEnum;
import com.hubbleadvance.utils.ideveloper.common.session.HttpSessionHelper;
import com.hubbleadvance.utils.ideveloper.common.utils.RequestUtil;
import com.hubbleadvance.utils.ideveloper.common.utils.ResponseUtil;
import com.hubbleadvance.utils.ideveloper.domain.user.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LoginFilter implements Filter {
    private static List<String> excludeUrlList;
    private static List<String> excludeStartWithList;
    private String basePath;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {   
        excludeUrlList = new ArrayList<String>();
        excludeUrlList.add("/login");
        
        excludeStartWithList = new ArrayList<String>();
        excludeStartWithList.add("/static");
        excludeStartWithList.add("/command");
        excludeStartWithList.add("/demo");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        if (basePath == null) {
            basePath = req.getContextPath();
        }
        String url = req.getRequestURI();
        for (String sw : excludeStartWithList) {
            if (url.startsWith(sw)) {
                chain.doFilter(request, response);
                return;
            }
        }
        
        if (excludeUrlList.contains(url)) {
            chain.doFilter(request, response);
            return;
        }
        boolean isAjax = RequestUtil.isAjax(req);
        User u = HttpSessionHelper.getCurrentLoginUser(req);
        if (u != null) {
            chain.doFilter(request, response);
            return;   
        }
        if(isAjax) {
            ResponseUtil.returnJsonResult(res, JsonResultCodeEnum.NO_LOGIN_ERROR.buildResult());
        } else {
            res.sendRedirect(req.getContextPath() + "/login");
        }
        
    }

    @Override
    public void destroy() {
        log.info("---LoginFilter destroyed");
    }

}
