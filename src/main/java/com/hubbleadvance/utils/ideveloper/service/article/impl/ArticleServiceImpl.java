package com.hubbleadvance.utils.ideveloper.service.article.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hubbleadvance.utils.ideveloper.dao.article.IArticleDao;
import com.hubbleadvance.utils.ideveloper.domain.article.Article;
import com.hubbleadvance.utils.ideveloper.domain.article.ArticleQuery;
import com.hubbleadvance.utils.ideveloper.service.article.IArticleService;
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private IArticleDao articleDao;
    
    @Override
    public boolean save(Article article) {
        // TODO Auto-generated method stub
        return articleDao.save(article)>0;
    }

    @Override
    public boolean batchSave(List<Article> articleList) {
        // TODO Auto-generated method stub
        return articleDao.batchSave(articleList) > 0;
    }

    @Override
    public PageInfo<Article> list(ArticleQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Article> list = articleDao.list(query);
        PageInfo<Article> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Article get(String id) {
        // TODO Auto-generated method stub
        return articleDao.get(id);
    }

    @Override
    public int saveVisited(String url) {
        // TODO Auto-generated method stub
        return articleDao.saveVisited(url);
    }

    @Override
    public List<String> listVisited() {
        // TODO Auto-generated method stub
        return articleDao.listVisited();
    }
}
