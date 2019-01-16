package com.hubbleadvance.utils.ideveloper.service.article;

import java.util.List;

import com.hubbleadvance.utils.ideveloper.domain.article.Article;

public interface IArticleService {
    boolean save(Article article);
    boolean batchSave(List<Article> articleList);
    
    List<Article> list();
}
