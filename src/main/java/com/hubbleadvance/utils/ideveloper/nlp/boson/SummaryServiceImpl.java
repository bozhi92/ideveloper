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
public class SummaryServiceImpl implements ISummaryService {

    @Override
    public String summaryAnalysis(String text, double p) {
        String summary = "";
        SummaryParam param = new SummaryParam();
        param.setContent(text);
        param.setTitle("");
        param.setNot_exceed(0);
        param.setPercentage(20);
        HttpResult result = HttpUtil.post(BosonConstants.SUMMARY, JSON.toJSONString(param), BosonConstants.HEADER);
        List<ClassifyData> datas = new ArrayList<>();
        if (result.isSuccess()) {
            summary = result.getBody();
        } else {
            log.error("summaryAnalysis request is fail -> \nstatus={},\nstatusText={}", result.getStatus(), result.getStatusText());
        }     
        return summary;
    }

}
