package com.hubbleadvance.utils.ideveloper.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="user")
@Entity
public class User {
    @Id
    private String id;
    private String uname;
    private String pwd;
    private Integer role;
}
