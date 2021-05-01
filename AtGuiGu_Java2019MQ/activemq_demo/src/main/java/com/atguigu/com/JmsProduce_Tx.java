package com.atguigu.com;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class JmsProduce_Tx {
    public static final String DEFAULT_BROKER_BIND_URL = "tcp://192.168.9.140:61616";
    public static final String QUERY_NAME = "tx01";

    public static void main(String[] args) throws JMSException {
        //1、创建连接工厂，按照给定的url地址,按照默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        //2 、 通过连接工厂，获取指定的connetction
        Connection connnction = activeMQConnectionFactory.createConnection();
        connnction.start();
//         3、创建会话session   两个参数: 第一个叫事物  这二个叫签收
        Session session = connnction.createSession(false, Session.CLIENT_ACKNOWLEDGE);
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
//         8、   通过messageProducer 发送msg
            messageProducer.send(textMessage);
        }
//        9、关闭资源
        messageProducer.close();
//        session.commit();// 事物为true的时候必须提交才能发送到队列中
        session.close();
        connnction.close();
        System.out.println("*************");
    }
}
