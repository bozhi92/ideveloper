package com.hubbleadvance.utils.ideveloper.controller;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private Object data;   
}
