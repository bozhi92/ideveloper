package com.hubbleadvance.utils.ideveloper.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;

import com.alibaba.fastjson.JSON;
import com.hubbleadvance.utils.ideveloper.nlp.BosonApiConstants;
import com.hubbleadvance.utils.ideveloper.nlp.boson.NerResult;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class HttpUtil {
    public static HttpResult post(String url, String body, Map<String, String> headers) {
        HttpResult result = new HttpResult();
        try {
            HttpResponse<String> jsonResponse = Unirest.post(url).headers(headers).body(body).asString();
            result.setBody(jsonResponse.getBody());
            result.setStatus(jsonResponse.getStatus());
            result.setStatusText(jsonResponse.getStatusText());
        } catch (UnirestException e){
            log.error("post请求出错, equestUrl="+url+", equestBody="+body);
            e.printStackTrace();
        }
        return result;
    }
    
    public static HttpResult post(String url, String body) {
        HttpResult result = new HttpResult();
        try {
            HttpResponse<String> jsonResponse = Unirest.post(url).header("Content-Type","application/json").body(body).asString();
            result.setBody(jsonResponse.getBody());
            result.setStatus(jsonResponse.getStatus());
            result.setStatusText(jsonResponse.getStatusText());
        } catch (UnirestException e){
            log.error("post请求出错, equestUrl="+url+", equestBody="+body);
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String data = "[\"中新网客户端南京1月10日电(记者崔佳明)10日,江苏金湖县官方就该县145名儿童接种过期疫苗事件通报,3名责任人被免职,5名相关人员被立案调查,同时,其他相关责任人当地纪委监委已介入调查处理。2019年1月7日,江苏金湖县黎城卫生院发生了一起口服过期疫苗事件。事件发生后,该县县委、县政府立即成立应急指挥部,统筹协调事件处置工作。通过对接种儿童家长的逐一电话排查,截至9日下午4时,该县共计145名儿童接种了过期脊灰疫苗。1月9日,金湖县委宣传部通报称,此次事件根本原因是管理混乱,工作失职,监管失灵。目前,该县纪委、监察委、卫生和计生委、市监局等有关部门已展开调查,并启动问责程序。涉事的黎城卫生院负责人和相关当事人、金湖县疾控中心领导班子成员和相关科室人员已经全部停职,接受调查处理。1月10日,当地官方通报,该县卫生计生委党委研究决定:对责任单位黎城卫生院、县疾控中心责令改正,给予警告;对县疾控中心分管副主任杨万琴、疾控一科主持工作的副科长韩伟、黎城卫生院主持工作的副院长刘志兵给予免职处理;对黎城卫生院疫苗管理员孙定兰,接种人员郭岳涧、杨士涛,县疾控中心疾控一科工作人员柏云霞、宋爱佳给予立案调查;其他相关责任人县纪委监委已介入调查处理。(完)\"]";
        String url = "http://api.bosonnlp.com/ner/analysis";
        Map<String,String> headers= new HashMap<>();
        headers.put("X-Token", BosonApiConstants.TOKEN);
        headers.put("Content-Type","application/json");
        HttpResult result = post(url, data, headers);
        
        if (result.isSuccess()) {
            String body = result.getBody();
            List<NerResult> re = JSON.parseObject(body, List.class);
            for (NerResult ner : re) {
                List<String> words = ner.getWord();
                List<List> entitys = ner.getEntity();
                for (List l : entitys) {
                    int start = (int)l.get(0);
                    int end = (int)l.get(1);
                    String type = (String)l.get(2);
                    for (int i=start;i<end;i++) {
                        String word = words.get(i);
                        System.out.println(word+"="+type);
                    }
                }
            }
            System.out.println(re.toString());
        } else {
            System.out.println("status:"+result.getStatus()+",statusText:"+result.getStatusText());
        }
        
//        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
//        List<String> keywordList = HanLP.extractKeyword(content, 15);
//        System.out.println(keywordList);
    }
    
}
@Data
class HttpResult {
    private String statusText;
    private int status;
    private String body;
    
    public boolean isSuccess() {
        return this.status == HttpStatus.SC_OK;
    }
}
