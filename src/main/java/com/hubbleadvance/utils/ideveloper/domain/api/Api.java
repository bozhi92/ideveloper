package com.hubbleadvance.utils.ideveloper.domain.api;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.hubbleadvance.utils.ideveloper.common.annotation.valid.IdValid;

import lombok.Data;
@Data
public class Api {
    private String id;
    @IdValid
    private String fid;
    @NotBlank(message="名称不能为空")
    private String name;
    @NotBlank(message="url不能为空")
    private String url;
    @NotNull(message="请求方式不能为空")
    private Integer type;
    private String uid;
    private int seq;
    private String params;
    private String headers;
    private String body;

    private List<Param> paramList;
    private List<Header> headerList;
    private Body bodyData;
}
