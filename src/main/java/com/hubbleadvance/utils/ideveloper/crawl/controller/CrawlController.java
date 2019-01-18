package com.hubbleadvance.utils.ideveloper.crawl.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubbleadvance.utils.ideveloper.crawl.cnblog.CnblogTemp;
import com.hubbleadvance.utils.ideveloper.domain.article.Article;
import com.hubbleadvance.utils.ideveloper.domain.article.ArticleQuery;
import com.hubbleadvance.utils.ideveloper.service.article.IArticleService;

@Controller
public class CrawlController {
    @Autowired
    private CnblogTemp cnblogTemp;
    @Autowired
    private IArticleService articleService;
    
    @RequestMapping(value="/crawl/cnblog")
    @ResponseBody
    public String cnblog() throws IOException, ParseException{
        cnblogTemp.crawl();
        return "ok";
    }
    
    @RequestMapping(value="/crawl/article/list")
    public String list(Model model, ArticleQuery query) { 
        model.addAttribute("pageInfo",articleService.list(query));
        return "article/list";
    }
    
    @RequestMapping(value="/crawl/article/ajaxList")
    public String ajaxList(Model model, ArticleQuery query) { 
        model.addAttribute("pageInfo",articleService.list(query));
        return "article/listFrag";
    }
    
    @RequestMapping(value="/crawl/article/{id}")
    public Object get(@PathVariable("id") String id, Model model) {
        Article article = articleService.get(id);
        model.addAttribute("article", article);
        return "article/article";
    }
}
