package com.hubbleadvance.utils.ideveloper.nlp.boson;

import java.util.List;

public interface IClassifyService {
    List<ClassifyData> classifyAnalysis(String[] text);
}
