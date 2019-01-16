//package com.hubbleadvance.utils.ideveloper.demo.crawl.main;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.commons.lang3.StringUtils;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import com.alibaba.fastjson.JSONObject;
//import com.github.pagehelper.Page;
//import com.hubbleadvance.utils.ideveloper.common.utils.IdUtil;
//import com.hubbleadvance.utils.ideveloper.demo.crawl.link.Links;
//import com.hubbleadvance.utils.ideveloper.demo.crawl.page.PageParserTool;
//
//import cn.bruk.anosa.crawl.page.RequestAndResponseTool;
//import cn.bruk.anosa.domain.news.News;
//import net.vidageek.crawler.PageCrawler;
//import net.vidageek.crawler.config.CrawlerConfiguration;
//
//public class MyCrawler {
//    /**
//     * 使用种子初始化 URL 队列
//     *
//     * @param seeds 种子 URL
//     * @return
//     */
//    public static void initCrawlerWithSeeds(String[] seeds) {
//        for (int i = 0; i < seeds.length; i++){
//            Links.addUnvisitedUrlQueue(seeds[i]);
//        }
//    }
// 
//    public boolean accept(String url) {
//        if (url.startsWith("https://news.cnblogs.com"))
//            return true;
//        else
//            return false;
//    }
// 
//    /**
//     * 抓取过程
//     *
//     * @param seeds
//     * @return
//     */
//    public static List<News> crawling(String[] seeds) {
//    	 SimpleDateFormat s =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
//    	List<News> newsList = null;
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        //初始化 URL 队列
//        initCrawlerWithSeeds(seeds);
// 
//        List<JSONObject> list = new ArrayList<JSONObject>();
//        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
//        int i = 0;
//        while (!Links.unVisitedUrlQueueIsEmpty()  && Links.getVisitedUrlNum() <= 1000) {
//            
//            //先从待访问的序列中取出第一个；
//            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
//            if (visitUrl == null){
//                continue;
//            }
//            
//            if (i==100) {
//                
//                break;
//            }
//            //根据URL得到page;
//            Page page = RequestAndResponseTool.sendRequstAndGetResponse(visitUrl);
//            if (page.getUrl().startsWith("https://news.cnblogs.com/n/")) {
//              //对page进行处理： 访问DOM的某个标签
//                Elements t= PageParserTool.select(page, "#news_title a");
//                Elements b= PageParserTool.select(page, "#news_body p");
//                Elements time= PageParserTool.select(page, "#news_info .time");
//                //Elements comment= PageParserTool.select(page, "#news_info .comment");
//                Elements tags= PageParserTool.select(page, "#news_more_info .news_tags a");
//                if(!t.isEmpty()){
//                    String[] tt = time.text().split(" ");
////                    System.out.println(tt[0]+":"+tt[1]);
//                    if (sdf.format(new Date()).equals(tt[1])) {
//                        i++;
////                      System.out.println("下面将打印所有a标签： ");
////                      System.out.println(es);
//                        News n = new News();
//                        n.setId(IdUtil.getSnowFlakeId());
//                        n.setTitle(t.text());
//                        n.setContent(getContent(b));
//                        String summary = "";
//                        if (n != null && n.getContent().length()> 200) {
//                        	summary = n.getContent().substring(0,200)+"...";
//                        } else {
//                        	summary = n.getContent();
//                        }
//                        n.setSummary(summary);
//                        n.setTags(tags.text());
//                        try {
//							n.setPublishTime(s.parse(time.text().substring(4)));
//						} catch (ParseException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//                        n.setCreateTime(new Date());
//                        n.setSourceUrl(visitUrl);
////                      JSONObject jsonObject = new JSONObject();
////                      jsonObject.put("title", t.text());
////                      jsonObject.put("content", getContent(b));
////                      
////                      jsonObject.put("time", time.text().substring(4));
////                      jsonObject.put("tags", tags.text());
//                      if (newsList ==null) {
//                      	newsList = new ArrayList<News>();
//                      }
//                      newsList.add(n);
//                    }
//                    
//                }
//            }
//            
// 
//            //将保存文件
//            //FileTool.saveToLocal(page);
// 
//            //将已经访问过的链接放入已访问的链接中；
//            Links.addVisitedUrlSet(visitUrl);
// 
//            //得到超链接
//            Set<String> links = PageParserTool.getLinks(page,"img");
//            if (links != null) {
//                links.addAll(PageParserTool.getLinks(page, "a"));
//            }
//            
//            for (String link : links) {
//                if (link.startsWith("https://news.cnblogs.com/n/") && link.endsWith("/")) {
//                   String key = link.substring("https://news.cnblogs.com/n/".length(), link.length()-1);
//                   if (StringUtils.isNumeric(key) && Integer.valueOf(key)>609360 || key.startsWith("page")) {
//                       Links.addUnvisitedUrlQueue(link);
//                       System.out.println("新增爬取路径: " + link);
//                   }
//                }   
//            }
//        }
////        SimpleDateFormat s =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
////        list.sort(new Comparator<JSONObject>() {
////
////			@Override
////			public int compare(JSONObject o1, JSONObject o2) {
////				// TODO Auto-generated method stub
////				try {
////					return s.parse(o1.getString("time")).getTime()<s.parse(o2.getString("time")).getTime() ? 1:-1;
////				} catch (ParseException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////				return 0;
////			}
////		});
//        return newsList;
//    }
// 
//    public static String getContent(Elements b) {
//        StringBuilder sb = new StringBuilder();
//        for (Element element : b) {
//            if (sb.length() != 0)
//                sb.append(System.getProperty("line.separator"));
//            sb.append(element.text());
//        }
//        return sb.toString();
//    }
//    
//    //main 方法入口
//    public static void main(String[] args) {
////        MyCrawler crawler = new MyCrawler();
////        crawler.crawling(new String[]{"https://news.cnblogs.com"});   
//        CrawlerConfiguration cfg = new CrawlerConfiguration("http://www.ashvsash.net/");
//        PageCrawler crawler = new PageCrawler(cfg);
//        MyPageVisitor mv = new MyPageVisitor();
//        crawler.crawl(mv);
////        String urlRegex = "(http://|https://|//)[^\":<>]*\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png)";
////        Pattern pattern = Pattern.compile( urlRegex, Pattern.CASE_INSENSITIVE );// 匹配表达式，忽略大小写  
////        Matcher matcher2 = pattern.matcher("http://avatar.csdn.net/9/B/D/3_zmx729618.jpg");  
////        // 对匹配的集合进行循环处理，将文件保存到本地  
////       while ( matcher2.find() ) {
////          System.out.println(matcher2.group(2));
////       } 
//    }
//}
