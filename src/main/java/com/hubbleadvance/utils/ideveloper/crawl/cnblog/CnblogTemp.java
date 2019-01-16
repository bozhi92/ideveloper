package com.hubbleadvance.utils.ideveloper.crawl.cnblog;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hubbleadvance.utils.ideveloper.crawl.FileUtil;
import com.hubbleadvance.utils.ideveloper.domain.article.Article;

public interface CnblogTemp {
    public static Article parse(String url) throws IOException {  
        Article article = null;
        if (url.startsWith("https://www.cnblogs.com/")) {
            if((url.indexOf("/p/")>-1||url.indexOf("/archive/")>-1) && url.endsWith(".html")) {
                article = new Article();
                Document doc = Jsoup.connect(url).get();
                String title = doc.select("#cb_post_title_url").text();
                String date = doc.select("#post-date").text();
                Elements info = doc.select("#post-date").next();
                String user = info.get(0).text();
                String userUrl = info.get(0).attr("abs:href");
                Elements body = doc.select("#cnblogs_post_body");
                String downloadFilePath = "G://downloadImage//";
                Elements imgs = body.select("img[src]");
                for (Element img : imgs) {
                    String abs = img.attr("abs:src");
                    if (abs.indexOf("cnblogs.com/blog/")>-1) {
                        String src = FileUtil.downImages(downloadFilePath, abs);
                        System.out.println("为:"+src);
                    }
                }
                String content = body.html();
            }              
        }
        return article;
    }
}
