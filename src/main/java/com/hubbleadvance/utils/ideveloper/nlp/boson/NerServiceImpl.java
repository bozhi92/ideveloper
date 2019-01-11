package com.hubbleadvance.utils.ideveloper.nlp.boson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hubbleadvance.utils.ideveloper.common.utils.HttpResult;
import com.hubbleadvance.utils.ideveloper.common.utils.HttpUtil;
import com.hubbleadvance.utils.ideveloper.nlp.BosonConstants;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class NerServiceImpl implements INerService {

    @Override
    public List<List<NerData>> nerAnalysis(String[] text) {
        HttpResult result = HttpUtil.post(BosonConstants.NER, JSON.toJSONString(text), BosonConstants.HEADER);
        List<List<NerData>> datasList = new ArrayList<>();
        if (result.isSuccess()) {
            String body = result.getBody();
            List<NerResult> re = JSON.parseObject(body, new TypeReference<List<NerResult>>(){});
            for (NerResult ner : re) {
                List<NerData> datas = new ArrayList<>();
                List<String> words = ner.getWord();
                List<Object[]> entitys = ner.getEntity();
                for (Object[] arr : entitys) {
                    int start = (int)arr[0];
                    int end = (int)arr[1];
                    String type = (String)arr[2];
                    String word = "";
                    for (int i=start;i<end;i++) {
                        word += words.get(i);
                    }
                    NerData data = new NerData();
                    data.setWord(word);
                    data.setType(type);
                    data.setTypeName(BosonConstants.parseNerName(type));
                    datas.add(data);
                }
                datasList.add(datas);
            }
        } else {
            log.error("nerAnalysis request is fail -> \nstatus={},\nstatusText={}", result.getStatus(), result.getStatusText());
        }
        return datasList;    
    }

}
