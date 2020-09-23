//package org.zju.vipa.aix.web.container.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.zju.vipa.aix.container.common.config.NetworkConfig;
//import sun.nio.ch.Net;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Date: 2020/6/24 9:34
// * @Author: EricMa
// * @Description:
// */
//public class ClientRealTimeLogConsumerMaven {
//    KafkaConsumer<String, String> consumer;
//
//
//    public void recv(){
//        init();
//
////        while (true){
//            // 拉取数据，指定轮询时间为1秒
//            ConsumerRecords<String, String> consumerRecords = consumer.poll(0);
//            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
//                System.out.println(consumerRecord.toString());
//            }
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
////        }
//    }
//
//    private void init(){
//        // 1. 消费者配置
//        Properties properties = new Properties();
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, NetworkConfig.KAFKA_SERVER_URL);
//        // 自动提交offset
//        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        // 提交offset的时间，单位ms，即1秒钟提交一次
//        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
//        // 指定k-v反序列化规则
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        // 指定消费者组
//        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "aix-container-web");
//
//        // 2. 创建消费者
//         consumer = new KafkaConsumer<>(properties);
//        // 订阅topic
//        consumer.subscribe(Collections.singletonList(NetworkConfig.KAFKA_TOPIC));
//    }
//}
