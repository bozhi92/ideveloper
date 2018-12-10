package com.hubbleadvance.utils.ideveloper.service.api;

import java.util.List;

import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.domain.api.ApiDoc;

public interface IApiDocService {
    List<ApiDoc> listByFolderId(String fid);
    
    ApiDoc get(String id);
    
    JsonResult add(ApiDoc entity);
    
    ApiDoc update(ApiDoc entity);
    
    boolean remove(String id);
}
