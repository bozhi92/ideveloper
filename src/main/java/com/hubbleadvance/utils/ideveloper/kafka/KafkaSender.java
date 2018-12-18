//package com.hubbleadvance.utils.ideveloper.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@Slf4j
//public class KafkaSender {
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//    
//    public void send(String json,String topic) {
//
//        //发送消息
//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, json);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//                log.info("Produce: The message failed to be sent:" + throwable.getMessage());
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, String> stringObjectSendResult) {
//                //TODO 业务处理
//                log.info("Produce: The message was sent successfully:");
//                log.info("Produce: _+_+_+_+_+_+_+ result: " + stringObjectSendResult.toString());
//            }
//        });
//    }
//}
