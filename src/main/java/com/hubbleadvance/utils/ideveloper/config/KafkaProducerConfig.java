//package com.hubbleadvance.utils.ideveloper.config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//@Configuration
//public class KafkaProducerConfig {
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String kafkaServers;
//    @Value("${spring.kafka.producer.retries_config}")
//    private String retriesConfig;
//    @Value("${spring.kafka.producer.batch_size_config}")
//    private String batchSize;
//    @Value("${spring.kafka.producer.linger_ms_config}")
//    private String lingerMs;
//    @Value("${spring.kafka.producer.buffer_memory_config}")
//    private String bufferMemory;
//    @Value("${spring.kafka.producer.max_request_size_config}")
//    private String maxRequestSize;
//
//
//     public Map<String, Object> producerConfigs() {
//            System.out.println("加载Kafak生产者配置中....................");
//            Map<String, Object> props = new HashMap<>();
//            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
//            props.put(ProducerConfig.RETRIES_CONFIG, retriesConfig);
//            props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
//            props.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
//            props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
//            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//            props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSize);
//            return props;
//        }
//
//        public ProducerFactory<String, String> producerFactory() {
//            return new DefaultKafkaProducerFactory<>(producerConfigs());
//        }
//
//        @Bean
//        public KafkaTemplate<String, String> kafkaTemplate() {
//            return new KafkaTemplate<String, String>(producerFactory());
//        }
//}
