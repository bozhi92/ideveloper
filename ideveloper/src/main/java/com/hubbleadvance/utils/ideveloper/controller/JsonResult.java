package com.hubbleadvance.utils.ideveloper.controller;

import lombok.Data;

@Data
public class JsonResult {
    private String code;
    private String msg;
    private Object data;
    
}
