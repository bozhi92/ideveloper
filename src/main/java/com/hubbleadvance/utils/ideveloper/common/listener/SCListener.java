package com.hubbleadvance.utils.ideveloper.common.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.hubbleadvance.utils.ideveloper.domain.funcation.Function;
import com.hubbleadvance.utils.ideveloper.service.function.IFunctionService;

public class SCListener implements ServletContextListener {
    @Autowired
    private IFunctionService functionService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Function> funList = functionService.listAll();
        if (CollectionUtils.isNotEmpty(funList)) {
            
        }
        System.out.println("servletContext init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        
    }

}
