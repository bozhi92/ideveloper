package com.hubbleadvance.utils.ideveloper.domain.demo;

import com.hubbleadvance.utils.ideveloper.common.annotation.valid.IdValid;

import lombok.Data;

@Data
public class Demo {
    @IdValid
    private String id;
}
