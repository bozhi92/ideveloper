package com.hubbleadvance.utils.ideveloper.crawl.cnblog;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hubbleadvance.utils.ideveloper.common.utils.IdUtil;
import com.hubbleadvance.utils.ideveloper.demo.crawl.link.Links;
import com.hubbleadvance.utils.ideveloper.domain.article.Article;
import com.hubbleadvance.utils.ideveloper.domain.rule.Line;
import com.hubbleadvance.utils.ideveloper.domain.rule.Option;
import com.hubbleadvance.utils.ideveloper.domain.rule.Rule;
import com.hubbleadvance.utils.ideveloper.service.article.IArticleService;

@Service
public class CnblogTempImpl implements CnblogTemp{
    @Autowired
    private IArticleService articleService;
    @Override
    public void crawl() throws IOException, ParseException {
        String[] start = {"https://www.cnblogs.com/"};
        List<String> urls = articleService.listVisited();
        if (CollectionUtils.isNotEmpty(urls)) {
            for (String u: urls){
                Links.addVisitedUrlSet(u); 
            }
        }
        initCrawlerWithSeeds(start);
        int i = 0;// && Links.getVisitedUrlNum() <= 1000
        while (!Links.unVisitedUrlQueueIsEmpty()) {
            String visitUrl = (String)Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null){
                continue;
            }
//            if (i==100) {
//                break;
//            }    
            Document doc = Jsoup.connect(visitUrl)
                    //.timeout(10000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Accept-Language", "zh-CN,zh;q=0.9")
                    .header("cookie","_ga=GA1.2.1916901186.1546485922; __gads=ID=60b3751d46793a7c:T=1546485914:S=ALNI_MZZNIa4PEc84vCETqjpjjO3FDIkfQ; UM_distinctid=16816c344f9105-00044db02e620b-58422116-1fa400-16816c344fcaa8; CNZZDATA1000205457=1908536604-1546565242-https%253A%252F%252Fwww.baidu.com%252F%7C1546565242; _gid=GA1.2.1498051252.1547430584; CNZZDATA4366031=cnzz_eid%3D804414752-1547709388-null%26ntime%3D1547709388; .CNBlogsCookie=111A24E611C946E23FF9F6864E2720F02C06B9189C1049A6A1C3DBA3E389126416E1FCBD63301B658E38D1008EEC647F04141FF1D8C9131662D50A1CCDB7F2F255FF588E63F4F6CAFA8A2F92D572B6B9A35F031A175B4BB8E4E6C73DDAAB9B66A4849ABB; .Cnblogs.AspNetCore.Cookies=CfDJ8KlpyPucjmhMuZTmH8oiYTPWGMtDdPj_E66M3TZrgiacs66rkaS4Yy3uwVD4eaTT7ni7lW8C9dzZJ-Na-8sao-q9uy7BF7aaFrrcom3WU5b4ObAMR8Rpv0kl5PvTy73r7Ga01Rj7GhwdCvpb5VdC87xZl7Bp4IRkFmJ2FTM3dWwAFvoyCtpI0qX22yy7HqN3zjNAzgXAPZvQiC2A83c9__7XcaIwL8Iv6uOGV0Cs6ewDspnYq-7QFYSssV8dV9guiH3V7Eez4dVpVC_6_HHiCOAhsU5uNzkfn_26m4y_5fS87uJyQjewmVjTzuew4EH03w; _gat=1")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                    .get();
            Article article = parse(doc, visitUrl);
            if (article != null) {
                i++;
                articleService.save(article);
                articleService.saveVisited(visitUrl);
            }
            Links.addVisitedUrlSet(visitUrl);
            
            Elements els = doc.select("a[href]");
            for (Element link : els) {
                String url = link.attr("abs:href");
                if (url.startsWith("https://www.cnblogs.com/")) {
                   if(url.indexOf("/p/")>-1 && url.endsWith(".html")) {
                       Links.addUnvisitedUrlQueue(url);
                   } else if (url.indexOf("sitehome/p/")>-1) {
                       Links.addUnvisitedUrlQueue(url);
                   }
                }
            }
        }
    }
    
    public static void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++){
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }
    
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
    
    public static Article parse(Document doc, String url) throws IOException, ParseException {  
        Article article = null;
        if (url.startsWith("https://www.cnblogs.com/")) {
            if((url.indexOf("/p/")>-1||url.indexOf("/archive/")>-1) && url.endsWith(".html")) {
                article = new Article();
                String title = "";
                Elements es = doc.select("#cb_post_title_url");
                if (es.size()>0) {
                    title = es.get(0).text();
                    if (title.length()>100) {
                        System.out.println(title);
                    }
                }
                String date = doc.select("#post-date").text();
                Elements info = doc.select("#post-date").next();
                String author = "";
                String blog = "";
                if (info.size()>0) {
                    author = info.get(0).text();
                    blog = info.get(0).attr("abs:href");
                }
               
                Elements body = doc.select("#cnblogs_post_body");
//                String downloadFilePath = "G://downloadImage//";
//                Elements imgs = body.select("img[src]");
//                for (Element img : imgs) {
//                    String abs = img.attr("abs:src");
//                    if (abs.indexOf("cnblogs.com/blog/")>-1) {
//                        String src = FileUtil.downImages(downloadFilePath, abs);
//                        System.out.println("为:"+src);
//                    }
//                }
                String content = body.html();
                article.setAuthor(author);
                article.setBlog(blog);
                article.setTitle(title);
                if (title.length() > 100) {
                    System.out.println(title);
                }
                article.setContent(content);
                article.setSource("cnblog");
                article.setUrl(url);
                article.setId(IdUtil.getStrSnowFlakeId());
                article.setCraTime(new Date());
                if (StringUtils.isNotBlank(date)) {
                    article.setPubTime(sdf.parse(date));
                }
            }              
        }
        return article;
    }
    
    public static Article autoParse(Document doc, String url, Rule rule) throws IOException, ParseException {  
        Article article = null;
        boolean flag = true;
        
//        String[] url_start = rule.getUrl_start();
//        if (url_start != null && url_start.length > 0) {
//            for (String s : url_start) {
//                flag = url.startsWith(s);
//                if (!flag) {
//                    break;
//                }
//            }
//        }
//        
//        String[] url_include = rule.getUrl_include();
//        if (url_include != null && url_include.length > 0) {
//            for (String s : url_include) {
//                flag = url.indexOf(s) > -1;
//                if (!flag) {
//                    break;
//                }
//            }
//        }
//        
//        String[] url_end = rule.getUrl_end();
//        if (url_end != null && url_end.length > 0) {
//            for (String s : url_end) {
//                flag = url.endsWith(s);
//                if (!flag) {
//                    break;
//                }
//            }
//        }
        
        if (url.startsWith("https://www.cnblogs.com/")) {
            if((url.indexOf("/p/")>-1||url.indexOf("/archive/")>-1) && url.endsWith(".html")) {
                article = new Article();
                String title = doc.select("#cb_post_title_url").text();
                String date = doc.select("#post-date").text();
                Elements info = doc.select("#post-date").next();
                String author = "";
                String blog = "";
                if (info.size()>0) {
                    author = info.get(0).text();
                    blog = info.get(0).attr("abs:href");
                }
               
                Elements body = doc.select("#cnblogs_post_body");
//                String downloadFilePath = "G://downloadImage//";
//                Elements imgs = body.select("img[src]");
//                for (Element img : imgs) {
//                    String abs = img.attr("abs:src");
//                    if (abs.indexOf("cnblogs.com/blog/")>-1) {
//                        String src = FileUtil.downImages(downloadFilePath, abs);
//                        System.out.println("为:"+src);
//                    }
//                }
                String content = body.html();
                article.setAuthor(author);
                article.setBlog(blog);
                article.setTitle(title);
                article.setContent(content);
                article.setSource("cnblog");
                article.setUrl(url);
                article.setId(IdUtil.getStrSnowFlakeId());
                article.setCraTime(new Date());
                if (StringUtils.isNotBlank(date)) {
                    article.setPubTime(sdf.parse(date));
                }
            }              
        }
        return article;
    }
    
    public static void main(String[] args) {
        Rule rule = new Rule();
        List<Option> options = new ArrayList<>();
        Option op1 = new Option();
        op1.setType(1);
        op1.setLabel("http:123.com");
        Option op2 = new Option();
        op2.setType(3);
        op2.setLabel(".html");
        options.add(op1);
        options.add(op2);
        rule.setOptions(options);
        
        List<Line> lines = new ArrayList<>();
        Line line = new Line();
        line.setType(1);
        
        line.setPos(Arrays.asList(0,1));
        lines.add(line);
        rule.setLines(lines);
        System.out.println(JSON.toJSONString(rule));
        
        String result = "";
        List<JSONArray> list = new ArrayList<>();
        for (Line l : rule.getLines()) {
            int c = l.getType();
            List<Integer> ra = l.getPos();
            if (c == 1) {
                for (int i=0;i<ra.size();i++) {
                    int num = ra.get(i);
                    if (i == 0) {
                        result += "(";  
                    }
                    List<Option> o = rule.getOptions();
                    Option oo = o.get(num);
                    int type = oo.getType();
                    String d = oo.getLabel();
                    String ti = "";
                    if (type == 1) {
                        ti+="startwith:"+d;
                    }else if (type == 2) {
                        ti+="include:"+d;
                    }else if (type == 3) {
                        ti+="endwith:"+d;
                    }
                    result += ti;
                    if (i<ra.size()-1) {
                        result+=" and ";
                    }
                    if (i == ra.size()-1) {
                        result += ")";  
                    }
                }
            }
        }
        System.out.println(result);
    }
}
