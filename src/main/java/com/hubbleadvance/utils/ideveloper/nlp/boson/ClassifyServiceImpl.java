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
public class ClassifyServiceImpl implements IClassifyService {

    @Override
    public List<ClassifyData> classifyAnalysis(String[] text) {
        HttpResult result = HttpUtil.post(BosonConstants.CLASSIFY, JSON.toJSONString(text), BosonConstants.HEADER);
        List<ClassifyData> datas = new ArrayList<>();
        if (result.isSuccess()) {
            int[] re = JSON.parseObject(result.getBody(), new TypeReference<int[]>(){}); 
            for (int i : re) {
                ClassifyData data = new ClassifyData();
                data.setCode(i);
                data.setName(BosonConstants.CLASSIFY_MAP.get(i));
                datas.add(data);
            }
        } else {
            log.error("classifyAnalysis request is fail -> \nstatus={},\nstatusText={}", result.getStatus(), result.getStatusText());
        }     
        return datas;
    }

}
