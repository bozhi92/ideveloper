package com.hubbleadvance.utils.ideveloper.service.project;

import java.util.List;

import com.hubbleadvance.utils.ideveloper.domain.project.ProjectMember;

public interface IProjectMemberService {
    List<String> listProidByUser(String uid);
    List<ProjectMember> listByUser(String uid);
    
    List<String> listUidByProject(String proid);
    List<ProjectMember> listByProject(String proid);
    
    ProjectMember insert(ProjectMember entity);
    List<ProjectMember> insertAll(List<ProjectMember> entities);
    
    //ProjectMember del(String id);
}
