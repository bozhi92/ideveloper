package com.hubbleadvance.utils.ideveloper.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hubbleadvance.utils.ideveloper.domain.user.User;
@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    @Query(nativeQuery=true, value="select id, uname, pwd, role from user where uname = ?1")
    User getByUname(String uname);
}
