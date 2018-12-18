package com.hubbleadvance.utils.ideveloper.domain.user;

import lombok.Data;

@Data
public class User {
    private String id;
    private String uname;
    private String pwd;
    private Integer role;
}
