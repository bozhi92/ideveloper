package com.hubbleadvance.utils.ideveloper.domain.api;

import java.util.List;

import lombok.Data;
@Data
public class Body {
    private int type;
    private List<KVData> kvDatas;
    private Raw raw;
    
}
