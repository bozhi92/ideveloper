package com.hubbleadvance.utils.ideveloper.nlp.boson;

import java.util.List;

public interface IKeywordsService {
    List<List<KeywordsData>> keywordsAnalysis(String[] text);
}
