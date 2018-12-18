package com.hubbleadvance.utils.ideveloper.common.enums;

public enum UserRoleEnum {
    USER(1, ""),
    MANAGER(2, ""),
    CREATOR(64, "");
    
    private int key;
    private String value;
    
    UserRoleEnum(int k, String v) {
        this.key = k;
        this.value = v;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    
    
}
