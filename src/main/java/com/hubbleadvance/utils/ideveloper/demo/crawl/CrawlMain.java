package com.hubbleadvance.utils.ideveloper.demo.crawl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hubbleadvance.utils.ideveloper.demo.crawl.link.Links;

public class CrawlMain {
    public static void main(String[] args) throws IOException {
        String[] star = {"https://www.cnblogs.com/"};
        initCrawlerWithSeeds(star);
        int i = 0;
        while (!Links.unVisitedUrlQueueIsEmpty() && Links.getVisitedUrlNum() <= 1000) {
            //先从待访问的序列中取出第一个；
            String visitUrl = (String)Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null){
                continue;
            }
            if (i==1000) {
                break;
            }
            
            Document doc = Jsoup.connect(visitUrl).get();
            if (visitUrl.startsWith("https://www.cnblogs.com/")) {
                if((visitUrl.indexOf("/p/")>-1||visitUrl.indexOf("/archive/")>-1) && visitUrl.endsWith(".html")) {
                    String title = doc.select("#cb_post_title_url").text();
                    String date = doc.select("#post-date").text();
                    Elements info = doc.select("#post-date").next();
                    if (info!= null && info.size()>0) {
                        String user = info.get(0).text();
                        String userUrl = info.get(0).attr("abs:href");
                    }
                    Elements body = doc.select("#cnblogs_post_body");
                    
                    
//                    String downloadFilePath = "G://downloadImage//";
//                    Elements imgs = body.select("img[src]");
//                    for (Element img : imgs) {
//                        String abs = img.attr("abs:src");
//                        if (abs.indexOf("cnblogs.com/blog/")>-1) {
//                            //System.out.println("替换abs="+abs);
//                            String src = downImages(downloadFilePath, abs);
//                            img.attr("src", src);
//                           // System.out.println("为:"+src);
//                        }
//                    }
                    String content = body.html();
                    System.out.println("第"+(i+1)+"篇：《"+title+"》"); 
                    i++;
                }              
            }
            //将保存文件
            //FileTool.saveToLocal(page);
            //将已经访问过的链接放入已访问的链接中；
            Links.addVisitedUrlSet(visitUrl);
            //得到超链接
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
    
    public static String downImages(String filePath,String imgUrl) throws UnsupportedEncodingException {
        //图片url中的前面部分：例如"http://images.csdn.net/"
        String beforeUrl = imgUrl.substring(0,imgUrl.lastIndexOf("/")+1);
        //图片url中的后面部分：例如“20150529/PP6A7429_副本1.jpg”
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1);
        //编码之后的fileName，空格会变成字符"+"
        String newFileName = URLEncoder.encode(fileName, "UTF-8");
        //把编码之后的fileName中的字符"+"，替换为UTF-8中的空格表示："%20"
        newFileName = newFileName.replaceAll("\\+", "\\%20");
        //编码之后的url
        imgUrl = beforeUrl + newFileName;
        
        try {
            //创建文件目录
            File files = new File(filePath);
            if (!files.exists()) {
                files.mkdirs();
            }
            //获取下载地址
            URL url = new URL(imgUrl);
            //链接网络地址
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //获取链接的输出流
            InputStream is = connection.getInputStream();
            //创建文件，fileName为编码之前的文件名
            File file = new File(filePath + fileName);
            //根据输入流写入文件
            FileOutputStream out = new FileOutputStream(file);
            int i = 0;
            while((i = is.read()) != -1){
                out.write(i);
            }
            out.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath + fileName;
    }
}
