package com.hubbleadvance.utils.ideveloper.service.article.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hubbleadvance.utils.ideveloper.domain.article.Article;
import com.hubbleadvance.utils.ideveloper.service.article.IArticleService;
@Service
public class ArticleServiceImpl implements IArticleService {
    
    @Override
    public boolean save(Article article) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean batchSave(List<Article> articleList) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Article> list() {
        // TODO Auto-generated method stub
        return null;
    }

}
