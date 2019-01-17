package com.hubbleadvance.utils.ideveloper.crawl.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubbleadvance.utils.ideveloper.crawl.SourceEnum;
import com.hubbleadvance.utils.ideveloper.crawl.cnblog.CnblogTemp;
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
    public Object list(Model model) { 
        model.addAttribute("list",articleService.list(null));
        //model.addAttribute("source",SourceEnum.values());
        return "article/list";
    }
    
    @RequestMapping(value="/crawl/article/list/{search}")
    public Object search(Model model, @PathVariable("search")String search) { 
        model.addAttribute("list",articleService.list(search));
        //model.addAttribute("source",SourceEnum.values());
        return "article/list";
    }
    
    @RequestMapping(value="/crawl/article/{id}")
    public Object get(@PathVariable("id") String id, Model model) {
        model.addAttribute("article", articleService.get(id));
        return "article/article";
    }
}
