package com.hubbleadvance.utils.ideveloper.crawl;

public enum SourceEnum {
    CNBLOG("cnblog", "博客园", "https://www.cnblogs.com/");
    
    private String code;
    private String name;
    private String url;
    private SourceEnum(String code, String name, String url) {
        this.code = code;
        this.name = name;
        this.url = url;
    }
    public String getCode() {
        return this.code;
    }
    
    public static SourceEnum parse(String code) {
        SourceEnum result = null;
        switch (code) {
        case "cnblog":
            result = SourceEnum.CNBLOG;
            break;
        }
        return result;
    }
}
