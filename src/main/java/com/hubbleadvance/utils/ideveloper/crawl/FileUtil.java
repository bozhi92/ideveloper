package com.hubbleadvance.utils.ideveloper.crawl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.hubbleadvance.utils.ideveloper.common.utils.IdUtil;

public class FileUtil {
    private static final List<String> exts = Arrays.asList(".png",".jpg",".gif",".jpeg");
    public static String downImages(String filePath,String imgUrl) {
//        //图片url中的前面部分：例如"http://images.csdn.net/"
//        String beforeUrl = imgUrl.substring(0,imgUrl.lastIndexOf("/")+1);
//        //图片url中的后面部分：例如“20150529/PP6A7429_副本1.jpg”
//        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1);
//        //编码之后的fileName，空格会变成字符"+"
//        String newFileName = URLEncoder.encode(fileName, "UTF-8");
//        //把编码之后的fileName中的字符"+"，替换为UTF-8中的空格表示："%20"
//        newFileName = newFileName.replaceAll("\\+", "\\%20");
//        //编码之后的url
//        imgUrl = beforeUrl + newFileName;
        String ext;
        try {
            ext = imgUrl.substring(imgUrl.lastIndexOf("."), imgUrl.length());
        } catch (java.lang.StringIndexOutOfBoundsException e1) {
            ext = ".jpg";
        }
        if (ext.contains("?")) {
            ext = ext.substring(0, ext.indexOf("?"));
        }
        if (!exts.contains(ext.toLowerCase())) {
            ext = ".jpg";
        }
        String fileName = IdUtil.getStrSnowFlakeId()+ext;
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
            System.out.println(imgUrl);
            e.printStackTrace();
        }
        return filePath + fileName;
    }
}
