package com.hubbleadvance.utils.ideveloper.common.utils;

import org.apache.http.HttpStatus;

import lombok.Data;
@Data
public class HttpResult {
    private String statusText = "no response";
    private int status = 0;
    private String body;
    
    public boolean isSuccess() {
        return this.status == HttpStatus.SC_OK;
    }
}
