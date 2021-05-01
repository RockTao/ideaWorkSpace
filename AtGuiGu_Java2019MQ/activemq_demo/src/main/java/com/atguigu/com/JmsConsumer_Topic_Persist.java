package com.atguigu.com;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer_Topic_Persist {
    public static final String DEFAULT_BROKER_BIND_URL = "tcp://192.168.9.140:61616";
    public static final String TOPIC_NAME = "Topic_Persist";


    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("_---------------Z 4 ");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        Connection connnction = activeMQConnectionFactory.createConnection();
        connnction.setClientID("z4");
        Session session = connnction.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic,"Remarjk ------");
        connnction.start();
       Message message =  topicSubscriber.receive();
       while (message != null )
       {
           TextMessage textMessage = (TextMessage) message;
           System.out.println("_ 收到的持久化topic " +textMessage.getText());
           message = topicSubscriber.receive();
       }
         session.close();
         connnction.close();
    }
}
