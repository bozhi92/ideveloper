package com.hubbleadvance.utils.ideveloper.service.demo;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hubbleadvance.utils.ideveloper.controller.PageParam;
import com.hubbleadvance.utils.ideveloper.domain.demo.Demo;

public interface IDemoService {
    PageInfo<Demo> list(PageParam page);
    
    Demo get(String id);
    
    boolean save(Demo demo);
    boolean batchSave(List<Demo> demos);
    
    boolean update(Demo demo);
    
    boolean remove(String id);
    boolean batchRemove(List<String> ids);
}
