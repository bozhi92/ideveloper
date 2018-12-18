package com.hubbleadvance.utils.ideveloper;

import java.io.Serializable;

import lombok.Data;

@Data
public class TopWebsite implements Serializable {
    private int id;
    private int seq;
    private String name;
    private String domain;
    private String type;
}
