package com.hubbleadvance.utils.ideveloper.dao.article;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hubbleadvance.utils.ideveloper.domain.article.Article;
@Mapper
public interface IArticleDao {
    List<Article> list(@Param("search")String search);
    
    Article get(String id);
    
    int save(Article demo);
    int batchSave(List<Article> demos);
    
    int saveVisited(@Param("url")String url);
    List<String> listVisited();
}
