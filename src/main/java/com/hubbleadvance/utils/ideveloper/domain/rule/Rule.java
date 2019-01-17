package com.hubbleadvance.utils.ideveloper.domain.rule;

import java.util.List;

import lombok.Data;

@Data
public class Rule {
    private String id;
    
    private List<Option> options;
    private List<Line> lines;
}
