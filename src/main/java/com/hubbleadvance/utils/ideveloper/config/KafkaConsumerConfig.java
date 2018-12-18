//package com.hubbleadvance.utils.ideveloper.config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.AbstractMessageListenerContainer;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//
//@Configuration
//@EnableKafka
//public class KafkaConsumerConfig {
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String kafkaServers;
//    @Value("${spring.kafka.consumer.group-id}")
//    private String consumerGroup;
//    @Value("${spring.kafka.consumer.auto_commit_interval_ms_config}")
//    private String autoCommit;
//    @Value("${spring.kafka.consumer.session_timeout_ms_config}")
//    private String sessionTimeout;
//    @Value("${spring.kafka.consumer.auto_offset_reset_config}")
//    private String offsetReset;
//    @Value("${spring.kafka.consumer.fetch_max_bytes_config}")
//    private String fetchMaxBytes;
//    @Value("${spring.kafka.listener.concurrency}")
//    private Integer concurrency;
//    @Value("${spring.kafka.consumer.maxPollRecords}")
//    private Integer maxPollRecords;
//    @Value("${spring.kafka.consumer.pollTimeout}")
//    private Integer pollTimeout;
//
//
//    @Bean
//    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
//        System.out.println("加载Kafak生产者配置中....................");
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        factory.setConcurrency(concurrency);
//        factory.setBatchListener(true);
//        factory.getContainerProperties().setPollTimeout(pollTimeout);
//        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);
//        return factory;
//    }
//
//    private ConsumerFactory<String, String> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
//    }
//
//    private Map<String, Object> consumerConfigs() {
//        Map<String, Object> propsMap = new HashMap<>(10);
//        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
//        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
//        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommit);
//        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
//        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
//
//        propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
//        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetReset);
//        propsMap.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, fetchMaxBytes);
//        return propsMap;
//    }
//}
