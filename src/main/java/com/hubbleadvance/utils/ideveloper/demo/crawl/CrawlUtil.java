package com.hubbleadvance.utils.ideveloper.demo.crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlUtil {
    public static void getHtml() throws IOException {
        List<String> l = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();
        Connection con = Jsoup.connect("https://www.cnblogs.com/");
//        Map<String, String> cookies = new HashMap<>();
//        cookies.put("JSESSIONID_SHIRO", "6ba0a4c2-ebc6-4849-911e-4b0e904dd2d7");
//        con.cookies(cookies);
        Document doc = con.get();
        Elements links = doc.select("a[href]");
//        Elements media = doc.select("[src]");
//        Elements imports = doc.select("link[href]");
        for (Element link : links) {
            String url = link.attr("abs:href");
            if (url.startsWith("https://www.cnblogs.com/")) {
               if(url.indexOf("/p/")>-1 && url.endsWith(".html")) {
                   set.add(url);
               } else if (url.indexOf("sitehome/p/")>-1) {
                   set.add(url);
               }
            }
        }
        
        while (set.size()>0) {
            
        }
        
    }
    
    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
