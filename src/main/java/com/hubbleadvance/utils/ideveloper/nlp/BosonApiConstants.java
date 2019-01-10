package com.hubbleadvance.utils.ideveloper.nlp;

public class BosonApiConstants {
    public static final String TOKEN = "b5SjEpp3.32690.Nug2bj_YKpbb";
    
    //情感分析，参数url?auto(汽车)|kitchen(厨具)|food(餐饮)|news(新闻)|weibo(微博)
    public static final String sentiment = "http://api.bosonnlp.com/sentiment/analysis";
    //命名实体
    public static final String ner = "http://api.bosonnlp.com/ner/analysis";
    //文法分析http://docs.bosonnlp.com/depparser.html
    public static final String depparser = "http://api.bosonnlp.com/depparser/analysis"; 
    //关键词提取
    public static final String keywords = "http://api.bosonnlp.com/keywords/analysis";
    //新闻分类
    public static final String classify = "http://api.bosonnlp.com/classify/analysis";
    //语义联想
    public static final String suggest = "http://api.bosonnlp.com/suggest/analysis";
    //分词与词性标注
    public static final String tag = "http://api.bosonnlp.com/tag/analysis?space_mode=0&oov_level=3&t2s=0&&special_char_conv=0";
    //摘要
    public static final String summary = "http://api.bosonnlp.com/summary/analysis";
    
    
}
