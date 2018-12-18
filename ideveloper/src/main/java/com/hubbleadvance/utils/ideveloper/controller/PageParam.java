package com.hubbleadvance.utils.ideveloper.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class PageParam implements Page {
    private static final long serialVersionUID = 1L;
    
    @Min(value = 0, message = "pageNum无效的值")
    private int pageNum = 0;
    @Min(value = 1, message = "pageSize无效的值")
    @Max(value = 100, message = "pageSize无效的值")
    private int pageSize = 10;
    
}
