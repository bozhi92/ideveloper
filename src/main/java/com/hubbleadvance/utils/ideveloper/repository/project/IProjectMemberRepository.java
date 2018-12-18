//package com.hubbleadvance.utils.ideveloper.repository.project;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.hubbleadvance.utils.ideveloper.domain.project.ProjectMember;
//@Repository
//public interface IProjectMemberRepository extends JpaRepository<ProjectMember, String>{
//    @Query(nativeQuery=true, value="select proid from project_member where uid = ?1")
//    List<String> listProidByUser(String uid);
//    
//    @Query(nativeQuery=true, value="select id, proid, uid from project_member where uid = ?1")
//    List<ProjectMember> listByUser(String uid);
//    
//    @Query(nativeQuery=true, value="select proid from project_member where proid = ?1")
//    List<String> listUidByProject(String proid);
//    
//    @Query(nativeQuery=true, value="select id, proid, uid from project_member where proid = ?1")
//    List<ProjectMember> listByProject(String proid);
//}
