//package com.hubbleadvance.utils.ideveloper.demo.crawl.main;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.alibaba.fastjson.JSON;
//
//import net.vidageek.crawler.Page;
//import net.vidageek.crawler.PageVisitor;
//import net.vidageek.crawler.Status;
//import net.vidageek.crawler.Url;
//import net.vidageek.crawler.link.DefaultLinkFinder;
//import net.vidageek.crawler.link.FrameLinkFinder;
//import net.vidageek.crawler.link.IframeLinkFinder;
//import net.vidageek.crawler.link.ImageLinkFinder;
//
//public class MyPageVisitor implements PageVisitor{
//    public static int i = 0;
//    public static List<String> list = new ArrayList<>();
//    @Override
//    public void visit(Page page) {
//        //System.out.println(page.getContent());
//        
//        System.out.println(JSON.toJSONString(new ImageLinkFinder(page.getContent()).getLinks()));
//        System.out.println(JSON.toJSONString(new DefaultLinkFinder(page.getContent()).getLinks()));
//        System.out.println(JSON.toJSONString(new FrameLinkFinder(page.getContent()).getLinks()));
//        System.out.println(JSON.toJSONString(new IframeLinkFinder(page.getContent()).getLinks()));
////        if (page.getUrl().startsWith("https://news.cnblogs.com/n/") && page.getUrl().endsWith("/") && page.getUrl().length()>"https://news.cnblogs.com/n/".length()) {
////            String key = page.getUrl().substring("https://news.cnblogs.com/n/".length(), page.getUrl().length()-1);
////            if (StringUtils.isNumeric(key) && Integer.valueOf(key)>609360 || key.startsWith("page")) {
////                System.out.println(page.getContent());
////                list.add(page.getContent());
////            }
////         }
//        
//    }
//
//    @Override
//    public void onError(Url errorUrl, Status statusError) {
//        // TODO Auto-generated method stub
//        System.out.println("onError");
//        System.out.println("link="+errorUrl.link());
//        System.out.println("depth="+errorUrl.depth());
//        System.out.println("status="+JSON.toJSONString(statusError));
//    }
//
//    @Override
//    public boolean followUrl(Url url) {
////        if (url.link().startsWith("https://news.cnblogs.com/n/") && url.link().endsWith("/")) {
////            String key = url.link().substring("https://news.cnblogs.com/n/".length(), url.link().length()-1);
////            if (StringUtils.isNumeric(key) && Integer.valueOf(key)>609360 || key.startsWith("page")) {
////                System.out.println(url.link());
////                return true;
////               
////            }
////         } 
//        return false;
//    }
//
//}
