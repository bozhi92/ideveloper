package com.hubbleadvance.utils.ideveloper.service.api;

import java.util.List;

import com.hubbleadvance.utils.ideveloper.controller.JsonResult;
import com.hubbleadvance.utils.ideveloper.domain.api.Api;

public interface IApiService {
    List<Api> listByFolderId(String fid);
    
    Api get(String id);
    
    JsonResult add(Api api);
    
    Api update(Api api);
    
    boolean remove(String id);
}
