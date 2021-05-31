//package org.zju.vipa.aix.web.container.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//import org.zju.vipa.aix.web.container.controller.ClientController;
//
///**
// * @Date: 2020/6/23 16:34
// * @Author: EricMa
// * @Description:
// */
//@Component("logConsumer")
//public class ClientRealTimeLogConsumer {
////    private static final Logger logger = LoggerFactory.getLogger(ClientRealTimeLogConsumer.class);
//
//    @Autowired
//    ClientController clientController;
//
//    @KafkaListener(groupId = "aix-group", topics = {"client-realtime-log"})
//    public void listen(String data) {
//        clientController.addLog(data);
//        System.out.println("SimpleConsumer收到消息：" + data);
////        logger.info(MessageFormat.format("SimpleConsumer收到消息：{0}", data));
//    }
//}
