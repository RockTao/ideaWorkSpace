package com.atguigu.com;


import org.apache.activemq.ActiveMQConnectionFactory;
import sun.rmi.runtime.NewThreadAction;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;


public class JmsProduce {
//    public static final String DEFAULT_BROKER_BIND_URL = "tcp://192.168.9.140:61616";
//    public static final String DEFAULT_BROKER_BIND_URL = "nio://192.168.9.140:61618";
    public static final String DEFAULT_BROKER_BIND_URL = "tcp://192.168.9.140:61608";
    public static final String QUERY_NAME = "auto_nio";

    public static void main(String[] args) throws JMSException {
        List list = new ArrayList();

        //1、创建连接工厂，按照给定的url地址,按照默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        //2 、 通过连接工厂，获取指定的connetction
        Connection connnction = activeMQConnectionFactory.createConnection();
        connnction.start();
//         3、创建会话session   两个参数: 第一个叫事物  这二个叫签收
        Session session = connnction.createSession(false, Session.AUTO_ACKNOWLEDGE);
//     4、创建目的地(具体是队列还是主题)
//        Destination --> 右键 Diagrams  ——> 右键 show  Impleations
        Queue queue = session.createQueue(QUERY_NAME);
//            5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);

//         持久化设置
//        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT); // 非持久化
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT); // 持久化
//        6、通过使用messageProducer生产3条消息到MQ队列里面

        for (int i = 0; i < 3; i++) {
//            7、创建消息
            TextMessage textMessage = session.createTextMessage("message --------" + i); //l理解为一个字符串

//            textMessage.setStringProperty("c01","vip");
//         8、   通过messageProducer 发送msg
            messageProducer.send(textMessage);


//            MapMessage mapMessage=   session.createMapMessage();
//            mapMessage.setString("k1","MapMessage ------ZK1");
//            messageProducer.send(mapMessage);
        }
//        9、关闭资源
        messageProducer.close();
        session.close();
        connnction.close();
        System.out.println("*************");


    }

}
