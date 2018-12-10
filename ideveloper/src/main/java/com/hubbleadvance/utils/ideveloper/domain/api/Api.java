package com.hubbleadvance.utils.ideveloper.domain.api;

import java.util.List;

import lombok.Data;
@Data
public class Api {
    private String id;
    private String name;
    private String url;
    private int type;
    private List<Param> params;
    private List<Header> headers;
    private Body body;
    private String uid;
    private int seq;
}
