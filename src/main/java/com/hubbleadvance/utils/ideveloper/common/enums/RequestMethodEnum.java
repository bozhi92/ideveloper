package com.hubbleadvance.utils.ideveloper.common.enums;

import java.util.Arrays;
import java.util.List;

public enum RequestMethodEnum {
    GET(1, "get"),
    POST(2, "post"),
    PUT(3, "put"),
    PATCH(4, "patch"),
    DELETE(5, "delete"),
    COPY(6, "copy"),
    HEAD(7, "head"),
    OPTIONS(8, "options"),
    LINK(9, "link"),
    UNLINK(10, "unlink"),
    PURGE(11, "purge"),
    LOCK(12, "lock"),
    UNLOCK(13, "unlock"),
    PROPFIND(14, "propfind"),
    VIEW(15, "view");
    
    private int key;
    private String value;
    
    RequestMethodEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    
    public int getKey() {
        return this.key;
    }
    public String getValue() {
        return this.value;
    }
    
    public static RequestMethodEnum parse(String value) {
        RequestMethodEnum result = null;
        String v = value.toLowerCase();
        switch (v) {
        case "get":
            result = RequestMethodEnum.GET;
            break;
        case "post":
            result = RequestMethodEnum.POST;
            break;
        case "put":
            result = RequestMethodEnum.PUT;
            break;
        case "patch":
            result = RequestMethodEnum.PATCH;
            break;
        case "delete":
            result = RequestMethodEnum.DELETE;
            break;
        case "copy":
            result = RequestMethodEnum.COPY;
            break;
        case "head":
            result = RequestMethodEnum.HEAD;
            break;
        case "options":
            result = RequestMethodEnum.OPTIONS;
            break;
        case "link":
            result = RequestMethodEnum.LINK;
            break;
        case "unlink":
            result = RequestMethodEnum.UNLINK;
            break;
        case "purge":
            result = RequestMethodEnum.PURGE;
            break;
        case "lock":
            result = RequestMethodEnum.LOCK;
            break;
        case "unlock":
            result = RequestMethodEnum.UNLOCK;
            break;
        case "propfind":
            result = RequestMethodEnum.PROPFIND;
            break;
        case "view":
            result = RequestMethodEnum.VIEW;
            break;
        default:
            break;
        }
        return result;
    }
    
    public static RequestMethodEnum parse(int key) {
        RequestMethodEnum result = null;
        switch (key) {
        case 1:
            result = RequestMethodEnum.GET;
            break;
        case 2:
            result = RequestMethodEnum.POST;
            break;
        case 3:
            result = RequestMethodEnum.PUT;
            break;
        case 4:
            result = RequestMethodEnum.PATCH;
            break;
        case 5:
            result = RequestMethodEnum.DELETE;
            break;
        case 6:
            result = RequestMethodEnum.COPY;
            break;
        case 7:
            result = RequestMethodEnum.HEAD;
            break;
        case 8:
            result = RequestMethodEnum.OPTIONS;
            break;
        case 9:
            result = RequestMethodEnum.LINK;
            break;
        case 10:
            result = RequestMethodEnum.UNLINK;
            break;
        case 11:
            result = RequestMethodEnum.PURGE;
            break;
        case 12:
            result = RequestMethodEnum.LOCK;
            break;
        case 13:
            result = RequestMethodEnum.UNLOCK;
            break;
        case 14:
            result = RequestMethodEnum.PROPFIND;
            break;
        case 15:
            result = RequestMethodEnum.VIEW;
            break;
        default:
            break;
        }
        return result;
    }
    
    public static List<RequestMethodEnum> getRequestMethodList() {
        return Arrays.asList(values());
    }
    
}
