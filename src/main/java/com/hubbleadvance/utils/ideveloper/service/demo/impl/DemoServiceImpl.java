package com.hubbleadvance.utils.ideveloper.service.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hubbleadvance.utils.ideveloper.controller.PageParam;
import com.hubbleadvance.utils.ideveloper.dao.demo.IDemoDao;
import com.hubbleadvance.utils.ideveloper.domain.demo.Demo;
import com.hubbleadvance.utils.ideveloper.service.demo.IDemoService;
@Service
public class DemoServiceImpl implements IDemoService {
    @Autowired
    private IDemoDao demoDao;
    
    @Override
    public PageInfo<Demo> list(PageParam page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Demo> list = demoDao.list(page);
        PageInfo<Demo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Demo get(String id) {
        // TODO Auto-generated method stub
        return demoDao.get(id);
    }
    
    @Override
    public boolean save(Demo demo) {
        // TODO Auto-generated method stub
        return demoDao.save(demo) > 0;
    }

    @Override
    public boolean batchSave(List<Demo> demos) {
        // TODO Auto-generated method stub
        return demoDao.batchSave(demos) > 0;
    }

    @Override
    public boolean update(Demo demo) {
        // TODO Auto-generated method stub
        return demoDao.update(demo) == 1;
    }

    @Override
    public boolean remove(String id) {
        // TODO Auto-generated method stub
        return demoDao.remove(id) > 0;
    }

    @Override
    public boolean batchRemove(List<String> ids) {
        // TODO Auto-generated method stub
        return demoDao.batchRemove(ids) > 0;
    }

}
