package com.hubbleadvance.utils.ideveloper.dao.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hubbleadvance.utils.ideveloper.controller.Page;
import com.hubbleadvance.utils.ideveloper.domain.demo.Demo;
@Mapper
public interface IDemoDao {
    List<Demo> list(Page page);
    
    Demo get(String id);
    
    int save(Demo demo);
    int batchSave(List<Demo> demos);
    
    int update(Demo demo);
    
    int remove(String id);
    int batchRemove(List<String> ids);
}
