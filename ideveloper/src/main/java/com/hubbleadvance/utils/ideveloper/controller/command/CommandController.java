package com.hubbleadvance.utils.ideveloper.controller.command;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
//import com.hubbleadvance.utils.ideveloper.kafka.KafkaSender;

@RestController
public class CommandController {
//    @Autowired
//    private KafkaSender kafkaSender;
    @RequestMapping(value="/command/{param}")
    public Object command(@PathVariable String param) {
//        kafkaSender.send(param, "test_topic");
        return param;
    }
    
    //@KafkaListener(topics="nlp_cluster_iknows")
    public void excute(List<ConsumerRecord<String, String>> records,  Acknowledgment ack) {
        for(ConsumerRecord<String, String> record:records){
            System.out.println("收到消息："+record.value());
        }
    }
}
