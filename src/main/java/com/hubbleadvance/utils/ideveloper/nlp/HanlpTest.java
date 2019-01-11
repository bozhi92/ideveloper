package com.hubbleadvance.utils.ideveloper.nlp;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

public class HanlpTest {
    
    public static void main(String[] args) {
        String data = "中新网客户端南京1月10日电(记者崔佳明)10日,江苏金湖县官方就该县145名儿童接种过期疫苗事件通报,3名责任人被免职,5名相关人员被立案调查,同时,其他相关责任人当地纪委监委已介入调查处理。2019年1月7日,江苏金湖县黎城卫生院发生了一起口服过期疫苗事件。事件发生后,该县县委、县政府立即成立应急指挥部,统筹协调事件处置工作。通过对接种儿童家长的逐一电话排查,截至9日下午4时,该县共计145名儿童接种了过期脊灰疫苗。1月9日,金湖县委宣传部通报称,此次事件根本原因是管理混乱,工作失职,监管失灵。目前,该县纪委、监察委、卫生和计生委、市监局等有关部门已展开调查,并启动问责程序。涉事的黎城卫生院负责人和相关当事人、金湖县疾控中心领导班子成员和相关科室人员已经全部停职,接受调查处理。1月10日,当地官方通报,该县卫生计生委党委研究决定:对责任单位黎城卫生院、县疾控中心责令改正,给予警告;对县疾控中心分管副主任杨万琴、疾控一科主持工作的副科长韩伟、黎城卫生院主持工作的副院长刘志兵给予免职处理;对黎城卫生院疫苗管理员孙定兰,接种人员郭岳涧、杨士涛,县疾控中心疾控一科工作人员柏云霞、宋爱佳给予立案调查;其他相关责任人县纪委监委已介入调查处理。(完)";
        
//        String document = "算法可大致分为基本算法、数据结构的算法、数论算法、计算几何的算法、图的算法、动态规划以及数值分析、加密算法、排序算法、检索算法、随机化算法、并行算法、厄米变形模型、随机森林算法。\n" +
//                "算法可以宽泛的分为三类，\n" +
//                "一，有限的确定性算法，这类算法在有限的一段时间内终止。他们可能要花很长时间来执行指定的任务，但仍将在一定的时间内终止。这类算法得出的结果常取决于输入值。\n" +
//                "二，有限的非确定算法，这类算法在有限的时间内终止。然而，对于一个（或一些）给定的数值，算法的结果并不是唯一的或确定的。\n" +
//                "三，无限的算法，是那些由于没有定义终止定义条件，或定义的条件无法由输入的数据满足而不终止运行的算法。通常，无限算法的产生是由于未能确定的定义终止条件。";
//        List<String> sentenceList = HanLP.extractSummary(document, 3);
//        System.out.println(sentenceList);
        
//        Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
//        List<Term> termList = segment.seg(data);
//        for (Term t : termList) {
//            if (t.nature.equals(Nature.ns)) {
//                System.out.println("地名："+t.word);
//            }
//            if (t.nature.equals(Nature.nr) || t.nature.equals(Nature.nrj)|| t.nature.equals(Nature.nrf)) {
//                System.out.println("人名："+t.word);
//            }
//            if (t.nature.equals(Nature.nt)) {
//                System.out.println("机构名："+t.word);
//            }
//            if (t.nature.equals(Nature.t)) {
//                System.out.println("时间："+t.word);
//            }
//            if (t.nature.equals(Nature.nz)) {
//                System.out.println("专有："+t.word);
//            }
//        }
        //System.out.println(JSON.toJSONString(termList));
        System.out.println(JSON.toJSONString(Nature.nr.equals(Nature.nr1)));
    }
}
