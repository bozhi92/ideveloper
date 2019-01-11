package com.hubbleadvance.utils.ideveloper.nlp.boson;

import java.util.List;

import lombok.Data;
@Data
public class NerResult {
    private List<String> word;
    private List<String> tag;
    private List<Object[]> entity;
}
