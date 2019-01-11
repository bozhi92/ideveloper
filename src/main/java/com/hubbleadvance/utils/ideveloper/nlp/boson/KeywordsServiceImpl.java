package com.hubbleadvance.utils.ideveloper.nlp.boson;

import java.math.BigDecimal;
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
public class KeywordsServiceImpl implements IKeywordsService {

    @Override
    public List<List<KeywordsData>> keywordsAnalysis(String[] text) {
        HttpResult result = HttpUtil.post(BosonConstants.KEYWORDS, JSON.toJSONString(text), BosonConstants.HEADER);
        List<List<KeywordsData>> datasList = new ArrayList<>();
        if (result.isSuccess()) {
            List<List<Object[]>> re = JSON.parseObject(result.getBody(), new TypeReference<List<List<Object[]>>>(){});            
            for (List<Object[]> ll : re) {
                List<KeywordsData> datas = new ArrayList<>();
                for (Object[] arr : ll) {
                    KeywordsData data = new KeywordsData();
                    data.setWeight((BigDecimal)arr[0]);
                    data.setWord((String)arr[1]);
                    datas.add(data);
                }
                datasList.add(datas);
            }
        } else {
            log.error("keywordsAnalysis request is fail -> \nstatus={},\nstatusText={}", result.getStatus(), result.getStatusText());
        }     
        return datasList;
    }

}
