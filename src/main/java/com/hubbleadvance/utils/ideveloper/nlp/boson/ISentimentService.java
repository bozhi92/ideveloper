package com.hubbleadvance.utils.ideveloper.nlp.boson;

import java.util.List;

public interface ISentimentService {
    List<SentimentData> sentimentAnalysis(String[] text, String doamin);
}
