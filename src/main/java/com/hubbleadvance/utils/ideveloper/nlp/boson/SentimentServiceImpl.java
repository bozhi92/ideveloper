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
public class SentimentServiceImpl implements ISentimentService {

    @Override
    public List<SentimentData> sentimentAnalysis(String[] text, String doamin) {
        HttpResult result = HttpUtil.post(BosonConstants.SENTIMENT+"?"+doamin, JSON.toJSONString(text), BosonConstants.HEADER);
        List<SentimentData> datas = new ArrayList<>();
        if (result.isSuccess()) {
            List<BigDecimal[]> re = JSON.parseObject(result.getBody(), new TypeReference<List<BigDecimal[]>>(){});       
            for (BigDecimal[] arr : re) {
                SentimentData d = new SentimentData();
                d.setPos(arr[0]);
                d.setNeg(arr[1]);
                datas.add(d);
            }
        } else {
            log.error("sentimentAnalysis request is fail -> \nstatus={},\nstatusText={}", result.getStatus(), result.getStatusText());
        }
        return datas;
    }

}
