package com.hubbleadvance.utils.ideveloper.nlp.boson;

import java.util.List;

public interface INerService {
    List<List<NerData>> nerAnalysis(String[] text);
}
