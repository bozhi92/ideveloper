package com.hubbleadvance.utils.ideveloper.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hubbleadvance.utils.ideveloper.controller.Page;
import com.hubbleadvance.utils.ideveloper.domain.user.User;

@Mapper
public interface IUserDao {
    List<User> list(Page page);
    
    User get(String id);
    User getByUname(String uname);
    
    int save(User user);
    int batchSave(List<User> users);
    
    int update(User user);
    
    int remove(String id);
    int batchRemove(List<String> ids);
}
