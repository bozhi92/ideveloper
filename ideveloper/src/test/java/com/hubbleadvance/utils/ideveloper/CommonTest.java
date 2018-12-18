package com.hubbleadvance.utils.ideveloper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.http.HttpResponse;
import  org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.hubbleadvance.utils.ideveloper.domain.user.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonTest {
    public static void sync() throws ClientProtocolException, IOException {
        log.info("开始时间：" + new SimpleDateFormat("HH:mm:ss:SSS").format(new Date()));
        String filePath = "C:/Users/admin/Desktop/信源名单+核心新闻网站列表-20181119.xlsx";
        //验证
        boolean boo = ExcelUtil.validateExcel(filePath);
        List<Map> list = new ArrayList<>();
        if (boo) {
            list = ExcelUtil.readExcel2007(filePath);
        }else {
            list = ExcelUtil.readExcelXls(filePath);
        }
        log.info("结束时间：" + new SimpleDateFormat("HH:mm:ss:SSS").format(new Date()));

        String seq = "序号";
        String name = "网站名";
        String domain = "URL";
        String type = "类型";
        List<TopWebsite> websites = new ArrayList<TopWebsite>();
        for(int i=0;i<list.size();i++){
            TopWebsite website = new TopWebsite();
            Map<String, String> map = list.get(i);
            String seqs = map.get(seq);
            if (seqs != null) {
                website.setSeq(Integer.valueOf(seqs.substring(0, seqs.lastIndexOf("."))));
            }
            
            website.setName(map.get(name));
            website.setDomain(map.get(domain));
            website.setType(map.get(type));
            websites.add(website);
            if (i == 99) {
                break;
            }
        }
        System.out.println("website total ="+websites.size());
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //http://www.iknowsengine.com/modifier/syncTopWebsite
        HttpPost method = new HttpPost("http://10.6.5.210:8080/iknows/topwebsite/insert");
        method.addHeader("Content-type","application/json; charset=utf-8");
        method.setHeader("Accept", "application/json");  
        method.setHeader("token", "bozhi01_e901c8c698914fa6bac6ddf50105ddf3");
        method.setEntity(new StringEntity(JSON.toJSONString(websites), Charset.forName("UTF-8")));
        long startTime = System.currentTimeMillis();
        HttpResponse response = httpclient.execute(method);
        long endTime = System.currentTimeMillis();
        int statusCode = response.getStatusLine().getStatusCode();
        String body = "";
        System.out.println("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
        if (statusCode == HttpStatus.SC_OK) {
            // Read the response body
            body = EntityUtils.toString(response.getEntity());
        }
        System.out.println("返回结果："+body);
    }
    public static void main(String[] args) throws ClientProtocolException, IOException {
        
    }
}
