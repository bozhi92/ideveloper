package com.hubbleadvance.utils.ideveloper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.scripting.groovy.GroovyScriptEvaluator;

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

        for(int i=0;i<list.size();i++){
            Map<String, String> map = list.get(i);
        }
    }
    public static void main(String[] args) throws ClientProtocolException, IOException {
//        try {
//            Connection conn = new Connection("10.50.2.24");
//            conn.connect();
//            boolean isAuthenticated = conn.authenticateWithPassword("imonitor",
//            "inews");
//            if (isAuthenticated == false) {
//            throw new IOException("Authentication failed");
//            }
//            Session sess = conn.openSession();
//            sess.requestPTY("bash");
//            sess.startShell();
//            InputStream stdout = new StreamGobbler(sess.getStdout());
//            InputStream stderr = new StreamGobbler(sess.getStderr());
//            BufferedReader stdoutReader = new BufferedReader(
//            new InputStreamReader(stdout));
//            BufferedReader stderrReader = new BufferedReader(
//            new InputStreamReader(stderr));
//            BufferedReader inputReader = new BufferedReader(
//            new InputStreamReader(System.in));
//            PrintWriter out = new PrintWriter(sess.getStdin());
//            String temp = "";
//            while (!temp.equals("exit")) {
//            System.out.print("[root@vmone ~]#");
//            temp = inputReader.readLine();
//            out.println(temp);
//            out.flush();
//            String line = null;
//            while ((line = stdoutReader.readLine()) != null) {
//            if (line.length() == 0) {// line等于null从来不会发生，导致程序卡在这里
//            continue;
//            } else{
//            System.out.println(line);
//            }
//            }
//            System.out.println("Here is the output from stderr:");
//            while (true) {
//            line = stderrReader.readLine();
//            if (line == null)
//            break;
//            System.out.println(line);
//            }
//            }
//            System.out.println("ExitCode: " + sess.getExitStatus());
//            sess.close();
//            conn.close();
//            System.out.println("close connection");
//            } catch (IOException e) {
//            e.printStackTrace(System.err);
//            System.exit(2);
//            }

//        Class scriptClass = groovyScriptEngine.loadScriptByName("hello2.groovy");
//        GroovyObject scriptInstance = (GroovyObject)scriptClass.newInstance();
    }
}
