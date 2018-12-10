package com.hubbleadvance.utils.ideveloper.domain.folder;

import lombok.Data;

@Data
public class Folder {
    private String id;
    private String name;
    private int dep;
    private int seq;
    private String parid;
    private String uid;
}
