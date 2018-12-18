package com.hubbleadvance.utils.ideveloper.domain.api;

import lombok.Data;

@Data
public class KVData {
    private String key;
    private String value;
    private String description;
    private int seq;
}
