package com.hubbleadvance.utils.ideveloper.nlp;

import java.util.HashMap;
import java.util.Map;

public class BosonConstants {
    public static final String TOKEN = "b5SjEpp3.32690.Nug2bj_YKpbb";
    
    //情感分析，参数url?auto(汽车)|kitchen(厨具)|food(餐饮)|news(新闻)|weibo(微博)
    public static final String SENTIMENT = "http://api.bosonnlp.com/sentiment/analysis";
    //命名实体
    public static final String NER = "http://api.bosonnlp.com/ner/analysis";
    //文法分析http://docs.bosonnlp.com/depparser.html
    public static final String DEPPARSER = "http://api.bosonnlp.com/depparser/analysis"; 
    //关键词提取 ?top=数量
    public static final String KEYWORDS = "http://api.bosonnlp.com/keywords/analysis";
    //新闻分类
    public static final String CLASSIFY = "http://api.bosonnlp.com/classify/analysis";
    //语义联想
    public static final String SUGGEST = "http://api.bosonnlp.com/suggest/analysis";
    //分词与词性标注?space_mode=0&oov_level=3&t2s=0&&special_char_conv=0
    public static final String TAG = "http://api.bosonnlp.com/tag/analysis?space_mode=0&oov_level=3&t2s=0&&special_char_conv=0";
    //摘要
    public static final String SUMMARY = "http://api.bosonnlp.com/summary/analysis";
    
    public static final Map<String, String> HEADER;
    public static final Map<String, String> NER_MAP;
    public static final Map<Integer, String> CLASSIFY_MAP;
    static {
        HEADER = new HashMap<>();
        HEADER.put("X-Token", TOKEN);
        HEADER.put("Content-Type","application/json");
        
        NER_MAP = new HashMap<>();
        NER_MAP.put("time", "时间");
        NER_MAP.put("location", "地点");
        NER_MAP.put("person_name", "人名");
        NER_MAP.put("org_name", "组织名");
        NER_MAP.put("company_name", "公司名");
        NER_MAP.put("product_name", "产品名");
        NER_MAP.put("job_title", "职位");
        
        CLASSIFY_MAP = new HashMap<>();
        CLASSIFY_MAP.put(0, "体育");
        CLASSIFY_MAP.put(1, "教育");
        CLASSIFY_MAP.put(2, "财经");
        CLASSIFY_MAP.put(3, "社会");
        CLASSIFY_MAP.put(4, "娱乐");
        CLASSIFY_MAP.put(5, "军事");
        CLASSIFY_MAP.put(6, "国内");
        CLASSIFY_MAP.put(7, "科技");
        CLASSIFY_MAP.put(8, "互联网");
        CLASSIFY_MAP.put(9, "房产");
        CLASSIFY_MAP.put(10, "国际");
        CLASSIFY_MAP.put(11, "女人");
        CLASSIFY_MAP.put(12, "汽车");
        CLASSIFY_MAP.put(13, "游戏");
    }
    
    
    public static String parseNerName(String code) {
        String name = NER_MAP.get(code);
        return  name != null ? name : "其他";
    }
}
