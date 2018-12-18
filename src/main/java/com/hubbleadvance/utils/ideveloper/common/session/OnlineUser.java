package com.hubbleadvance.utils.ideveloper.common.session;

import java.io.Serializable;

import com.hubbleadvance.utils.ideveloper.domain.user.User;

import lombok.Data;
@Data
public class OnlineUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String uname;
    private Long loginTime;
    private String ip;
    
    public OnlineUser(User u){
        this.id = u.getId();
        this.uname = u.getUname();
    }
}
