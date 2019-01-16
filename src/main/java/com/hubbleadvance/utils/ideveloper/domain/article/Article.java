package com.hubbleadvance.utils.ideveloper.domain.article;

import java.util.Date;

import lombok.Data;

@Data
public class Article {
    private String id;
    private String title;
    private String content;
    private String source;
    private String url;
    private String author;
    private String blog;
    private Date pubTime;
    private Date craTime;
}
