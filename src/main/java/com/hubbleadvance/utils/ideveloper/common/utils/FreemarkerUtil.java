package com.hubbleadvance.utils.ideveloper.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerUtil {

    private static final Integer TEMPLATE_LOADING_FILE = 1;
    private static final Integer TEMPLATE_LOADING_PROJECT = 2;
    private static Configuration freemarkerConfig;

    static {
        try {
            initConfig(TEMPLATE_LOADING_PROJECT, "/templates");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化Freemarker参数配置
     *
     * @param type 模板文件夹路径类型，1：文件系统路径；2：项目路径
     * @param dir  模板文件夹路径，当type=1时，文件系统中的绝对路径；当type=2时，项目中相对路径，与src同级开始,以"/开头"
     * @throws Exception
     */
    public static void initConfig(Integer type, String dir) throws Exception {
        /**
         * 通过Freemaker的Configuration读取相应的ftl,配置Freemarker模板参数信息
         */
        freemarkerConfig = new Configuration(Configuration.VERSION_2_3_22);
        /**
         * 设置模板本件夹路径：
         * 1、setDirectoryForTemplateLoading，文件系统绝对路径
         * 2、setClassForTemplateLoading项目相对路径
         */
        if (TEMPLATE_LOADING_FILE.equals(type)) {
            try {
                freemarkerConfig.setDirectoryForTemplateLoading(new File(dir));
            } catch (IOException e) {
                throw new Exception("设置模板文件夹异常", e);
            }

        }
        if (TEMPLATE_LOADING_PROJECT.equals(type)) {
            freemarkerConfig.setClassForTemplateLoading(FreemarkerUtil.class, dir);
        }
    }

    /**
     * 获取Freemarker模板文件
     *
     * @param name 文件名
     * @return
     */
    public static Template getTemplate(String name) {
        Template temp = null;
        try {
            temp = freemarkerConfig.getTemplate(name, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;

    }

    /**
     * 将解析之后的文件内容保存到文件中
     *
     * @param name    模板文件名
     * @param root    数据Map
     * @param outFile 保存文件路径
     */
    public static void printFile(String name, Map<String, Object> root, String outFile) {
        FileWriter out = null;
        try {
            //通过一个文件输出流，就可以写到相应的文件中
            out = new FileWriter(new File(outFile));
            Template temp = getTemplate(name);
            temp.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将解析之后的文件内容返回字符串
     *
     * @param name 模板文件名
     * @param root 数据Map
     * @return
     */
    public static String printString(String name, Object root) {
        StringWriter out = new StringWriter();
        try {
            //通过一个文件输出流，就可以写到相应的文件中
            Template temp = getTemplate(name);
            temp.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }


}