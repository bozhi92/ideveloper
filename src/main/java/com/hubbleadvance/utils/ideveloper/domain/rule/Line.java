package com.hubbleadvance.utils.ideveloper.domain.rule;

import java.util.List;

import lombok.Data;

@Data
public class Line {
    private int type;
    private List<Integer> pos;
}
