package com.hubbleadvance.utils.ideveloper.repository.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hubbleadvance.utils.ideveloper.domain.api.ApiDoc;
@Repository
public interface IApiRepository extends JpaRepository<ApiDoc, String>{
    @Query(nativeQuery=true, value="select * from apidoc where fid = ?1")
    List<ApiDoc> listByFolderId(String fid);
}
