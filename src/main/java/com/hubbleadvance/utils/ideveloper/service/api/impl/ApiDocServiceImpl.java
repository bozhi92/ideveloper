package com.hubbleadvance.utils.ideveloper.service.api.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hubbleadvance.utils.ideveloper.common.enums.JsonResultCodeEnum;
import com.hubbleadvance.utils.ideveloper.common.utils.IdUtil;
import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.domain.api.ApiDoc;
import com.hubbleadvance.utils.ideveloper.domain.api.Body;
import com.hubbleadvance.utils.ideveloper.domain.api.Header;
import com.hubbleadvance.utils.ideveloper.domain.api.Param;
import com.hubbleadvance.utils.ideveloper.repository.api.IApiDocRepository;
import com.hubbleadvance.utils.ideveloper.service.api.IApiDocService;
@Service
public class ApiDocServiceImpl implements IApiDocService {
    @Autowired
    private IApiDocRepository apiRepository;
    
    @Override
    public List<ApiDoc> listByFolder(String fid) {
        List<ApiDoc> docList = apiRepository.listByFolder(fid);
        
        return docList;
    }

    @Override
    public ApiDoc get(String id) {
        // TODO Auto-generated method stub
        return apiRepository.getOne(id);
    }

    @Override
    public JsonResult add(ApiDoc entity) {
        entity.setId(IdUtil.getStrSnowFlakeId());
        Body body = entity.getBodyData();
        List<Header> headerList = entity.getHeaderList();
        List<Param> paramList = entity.getParamList();
        if (body != null) {
            entity.setBody(JSON.toJSONString(body));
        }
        if (CollectionUtils.isNotEmpty(headerList)) {
            entity.setHeaders(JSON.toJSONString(headerList));
        }
        if (CollectionUtils.isNotEmpty(paramList)) {
            entity.setParams(JSON.toJSONString(paramList));
        }
        ApiDoc inserted = apiRepository.saveAndFlush(entity);
        return inserted != null ? JsonResultCodeEnum.SUCCESS.buildResult(inserted): JsonResultCodeEnum.ERROR.buildResult();
    }

    @Override
    public ApiDoc update(ApiDoc entity) {
        // TODO Auto-generated method stub
        return apiRepository.saveAndFlush(entity);
    }

    @Override
    public boolean remove(String id) {
        apiRepository.deleteById(id);
        return true;
    }
    
}
