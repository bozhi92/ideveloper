package com.hubbleadvance.utils.ideveloper.service.article;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hubbleadvance.utils.ideveloper.domain.article.Article;
import com.hubbleadvance.utils.ideveloper.domain.article.ArticleQuery;

public interface IArticleService {
    boolean save(Article article);
    boolean batchSave(List<Article> articleList);
    
    Article get(String id);
    PageInfo<Article> list(ArticleQuery query);
    
    int saveVisited(String url);
    List<String> listVisited();
}
