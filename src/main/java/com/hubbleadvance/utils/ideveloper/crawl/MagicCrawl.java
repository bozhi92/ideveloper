package com.hubbleadvance.utils.ideveloper.crawl;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

public class MagicCrawl implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    public static final String list = "https://www.cnblogs.com/";
    @Override
    public Site getSite() {
        // TODO Auto-generated method stub
        return site;
    }

    @Override
    public void process(Page page) {
//        if(page.getUrl().regex("https://www.cnblogs.com/").match()) {
//            List<Selectable> list=page.getHtml().xpath("//*[@id='post_list']/div[@class='post_item']").nodes();
//            for (Selectable s : list) {
//                String title=s.xpath("//div[2]/h3/a/text()").toString();
//                page.putField("title", title);
//                
//            }
//        }
        page.putField("title",new JsonPathSelector("$.articles[*].title").selectList(page.getRawText()));
        
    }
    
    public static void main(String[] args) {
        Spider spider=Spider.create(new MagicCrawl());
        spider.addUrl("https://blog.csdn.net/api/articles?type=more&category=lang");
        //spider.addPipeline(new NewsPipeline());
        spider.thread(1);
        spider.setExitWhenComplete(true);
        spider.start();
    }

}
