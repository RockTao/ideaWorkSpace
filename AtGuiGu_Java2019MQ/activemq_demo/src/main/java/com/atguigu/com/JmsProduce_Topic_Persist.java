package com.atguigu.com;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce_Topic_Persist {

    public static final String DEFAULT_BROKER_BIND_URL = "tcp://192.168.9.140:61616";
    public static final String TOPIC_NAME = "Topic_Persist";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        Connection connnction = activeMQConnectionFactory.createConnection();
        Session session = connnction.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageProducer messageProducer = session.createProducer(topic);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);  //

        connnction.start();
        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("Topic Name --------" + i); //l理解为一个字符串
            messageProducer.send(textMessage);
        }
        messageProducer.close();
        session.close();
        connnction.close();
        System.out.println("***** Topic_Persist  完成 ********");

    }

}
