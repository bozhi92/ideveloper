package com.hubbleadvance.utils.ideveloper.dao.article;

import java.util.List;

import com.hubbleadvance.utils.ideveloper.controller.Page;
import com.hubbleadvance.utils.ideveloper.domain.article.Article;

public interface IArticleDao {
    List<Article> list(Page page);
    
    Article get(String id);
    
    int save(Article demo);
    int batchSave(List<Article> demos);
}
