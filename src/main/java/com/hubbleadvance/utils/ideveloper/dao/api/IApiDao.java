package com.hubbleadvance.utils.ideveloper.dao.api;

import java.util.List;

import com.hubbleadvance.utils.ideveloper.domain.api.Api;

public interface IApiDao {
    List<Api> listByFolder(String fid);
    
    Api get(String id);
    
    int save(Api apidoc);
    int batchSave(List<Api> apis);
    
    int update(Api api);
    
    int remove(String id);
    int batchRemove(List<String> ids);
}
