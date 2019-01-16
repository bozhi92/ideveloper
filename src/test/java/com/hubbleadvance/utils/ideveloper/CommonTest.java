package com.hubbleadvance.utils.ideveloper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.hubbleadvance.utils.ideveloper.common.utils.HttpResult;
import com.hubbleadvance.utils.ideveloper.common.utils.HttpUtil;
import com.hubbleadvance.utils.ideveloper.nlp.BosonConstants;
import com.hubbleadvance.utils.ideveloper.nlp.boson.IClassifyService;
import com.hubbleadvance.utils.ideveloper.nlp.boson.IKeywordsService;
import com.hubbleadvance.utils.ideveloper.nlp.boson.INerService;
import com.hubbleadvance.utils.ideveloper.nlp.boson.ISentimentService;
import com.hubbleadvance.utils.ideveloper.nlp.boson.SummaryParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationStart.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommonTest {
    @Autowired
    private INerService nerService;
    @Autowired
    private ISentimentService sentimentService;
    @Autowired
    private IKeywordsService keywordsService;
    @Autowired
    private IClassifyService classifyService;
    @Test
    public void nerTest() {
        String text = "[\"中新网客户端南京1月10日电(记者崔佳明)10日,江苏金湖县官方就该县145名儿童接种过期疫苗事件通报,3名责任人被免职,5名相关人员被立案调查,同时,其他相关责任人当地纪委监委已介入调查处理。2019年1月7日,江苏金湖县黎城卫生院发生了一起口服过期疫苗事件。事件发生后,该县县委、县政府立即成立应急指挥部,统筹协调事件处置工作。通过对接种儿童家长的逐一电话排查,截至9日下午4时,该县共计145名儿童接种了过期脊灰疫苗。1月9日,金湖县委宣传部通报称,此次事件根本原因是管理混乱,工作失职,监管失灵。目前,该县纪委、监察委、卫生和计生委、市监局等有关部门已展开调查,并启动问责程序。涉事的黎城卫生院负责人和相关当事人、金湖县疾控中心领导班子成员和相关科室人员已经全部停职,接受调查处理。1月10日,当地官方通报,该县卫生计生委党委研究决定:对责任单位黎城卫生院、县疾控中心责令改正,给予警告;对县疾控中心分管副主任杨万琴、疾控一科主持工作的副科长韩伟、黎城卫生院主持工作的副院长刘志兵给予免职处理;对黎城卫生院疫苗管理员孙定兰,接种人员郭岳涧、杨士涛,县疾控中心疾控一科工作人员柏云霞、宋爱佳给予立案调查;其他相关责任人县纪委监委已介入调查处理。(完)\",\"据报道，56岁的女神关之琳虽然婚姻并不圆满，但她凭借个人能力疯狂吸金，并创立了自己的服装品牌，拥有4亿多的身家，56岁的她还保持着冻龄容颜和完美身材活跃在大众视野中，自己依然活得很精致。关之琳的感情生活并不够理想，如今单身的她膝下也无子，身家不菲的她如果一直保持单身状态，她的财产归属状况就让人十分好奇了。有港媒对此报道称关之琳在往后的日子不会刻意寻找另一半，而是享受独处生活，还会把4亿多财产留给弟弟，原来关之琳有一位小11岁的亲弟，两人姐弟感情很好。\"]";
        
        System.out.println("ner===\n"+JSON.toJSONString(nerService.nerAnalysis(JSON.parseObject(text, String[].class))));
        //System.out.println("sentiment===\n"+JSON.toJSONString(sentimentService.sentimentAnalysis(JSON.parseObject(text, String[].class), "news")));
        //System.out.println("keywords===\n"+JSON.toJSONString(keywordsService.keywordsAnalysis(JSON.parseObject(text, String[].class))));
        //System.out.println("classify===\n"+JSON.toJSONString(classifyService.classifyAnalysis(JSON.parseObject(text, String[].class))));
    }
    public static void main(String[] args) {
        String text = "[\"中新网客户端南京1月10日电(记者崔佳明)10日,江苏金湖县官方就该县145名儿童接种过期疫苗事件通报,3名责任人被免职,5名相关人员被立案调查,同时,其他相关责任人当地纪委监委已介入调查处理。2019年1月7日,江苏金湖县黎城卫生院发生了一起口服过期疫苗事件。事件发生后,该县县委、县政府立即成立应急指挥部,统筹协调事件处置工作。通过对接种儿童家长的逐一电话排查,截至9日下午4时,该县共计145名儿童接种了过期脊灰疫苗。1月9日,金湖县委宣传部通报称,此次事件根本原因是管理混乱,工作失职,监管失灵。目前,该县纪委、监察委、卫生和计生委、市监局等有关部门已展开调查,并启动问责程序。涉事的黎城卫生院负责人和相关当事人、金湖县疾控中心领导班子成员和相关科室人员已经全部停职,接受调查处理。1月10日,当地官方通报,该县卫生计生委党委研究决定:对责任单位黎城卫生院、县疾控中心责令改正,给予警告;对县疾控中心分管副主任杨万琴、疾控一科主持工作的副科长韩伟、黎城卫生院主持工作的副院长刘志兵给予免职处理;对黎城卫生院疫苗管理员孙定兰,接种人员郭岳涧、杨士涛,县疾控中心疾控一科工作人员柏云霞、宋爱佳给予立案调查;其他相关责任人县纪委监委已介入调查处理。(完)\",\"据报道，56岁的女神关之琳虽然婚姻并不圆满，但她凭借个人能力疯狂吸金，并创立了自己的服装品牌，拥有4亿多的身家，56岁的她还保持着冻龄容颜和完美身材活跃在大众视野中，自己依然活得很精致。关之琳的感情生活并不够理想，如今单身的她膝下也无子，身家不菲的她如果一直保持单身状态，她的财产归属状况就让人十分好奇了。有港媒对此报道称关之琳在往后的日子不会刻意寻找另一半，而是享受独处生活，还会把4亿多财产留给弟弟，原来关之琳有一位小11岁的亲弟，两人姐弟感情很好。\"]";
        List<String> list = JSON.parseArray(text, String.class);
        List<SummaryParam> param = new ArrayList<>();

            SummaryParam s = new SummaryParam();
            s.setContent(list.get(1));
            s.setTitle("");
            s.setNot_exceed(0);
            s.setPercentage(20);


        HttpResult result = HttpUtil.post("http://10.50.1.202:9000?rcmd/158", JSON.toJSONString(s));
        //List<List<Object[]>> re = JSON.parseObject(result.getBody(), new TypeReference<List<List<Object[]>>>(){});
        System.out.println(result.getBody());
        //System.out.println(JSON.toJSONString(datas));
    }
    
    
    
    
    
    
    
    
    
//    public static void sync() throws ClientProtocolException, IOException {
//        log.info("开始时间：" + new SimpleDateFormat("HH:mm:ss:SSS").format(new Date()));
//        String filePath = "C:/Users/admin/Desktop/信源名单+核心新闻网站列表-20181119.xlsx";
//        //验证
//        boolean boo = ExcelUtil.validateExcel(filePath);
//        List<Map> list = new ArrayList<>();
//        if (boo) {
//            list = ExcelUtil.readExcel2007(filePath);
//        }else {
//            list = ExcelUtil.readExcelXls(filePath);
//        }
//        log.info("结束时间：" + new SimpleDateFormat("HH:mm:ss:SSS").format(new Date()));
//
//        for(int i=0;i<list.size();i++){
//            Map<String, String> map = list.get(i);
//        }
//    }
}
