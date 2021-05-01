package com.atguigu.com;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Map;

public class JmsConsumer {
//    public static final String DEFAULT_BROKER_BIND_URL = "tcp://192.168.9.140:61616";
//public static final String DEFAULT_BROKER_BIND_URL = "nio://192.168.9.140:61618";
    public static final String DEFAULT_BROKER_BIND_URL = "tcp://192.168.9.140:61608";
    public static final String QUERY_NAME = "auto_nio";



    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("我是2号消费者 ----");
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

        // 5、创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);
//     同步阻塞方式receive()
//        订阅者或接受者调用messageConsumer的receive()方法来接受消息，receive方法在能够接受到信息之前(或超时之前)将一直阻塞
        /**
         *

        while (true){
            TextMessage textMessage= (TextMessage) messageConsumer.receive(4000L);
          if (null != textMessage){
              System.out.println("接受到的消息:" + textMessage.getText());
          }else {
              break;
          }
        }
        messageConsumer.close();
        session.close();
        connnction.close();
         */

        // 第二种访问
//        通过监听的范式来消费消息
//        异步非阻塞方式(监听器onMessage())
//        订阅者或者接受者通过setMessageListener的setMessageListener(MessageListener listen)注册一个消息监听器
//        当消息到达后，系统自动调用监听器MessageListener的onMessage 方法
         messageConsumer.setMessageListener(new MessageListener() {
             public void onMessage(Message message) {
                 if(null != message && message instanceof  TextMessage )
                 {
                     TextMessage textMessage = (TextMessage) message;
                     try {
                         System.out.println("都二中方式:"+ textMessage.getText());
//                         System.out.println("消息属性:"+ textMessage.getStringProperty("c01"));
                     } catch (JMSException e) {
                         e.printStackTrace();
                     }
                 }
//                 if (null != message && message instanceof MapMessage){
//                     MapMessage mapMessage = (MapMessage) message;
//                     try {
//                         System.out.println(mapMessage.getString("k1"));
//                     } catch (JMSException e) {
//                         e.printStackTrace();
//                     }
//                 }
             }
         });
         System.in.read();
         messageConsumer.close();
         session.close();
         connnction.close();
        /**
         * 1、先生存   只启动1号消费者 问题：1号消费者能消费吗
         *   可以
         * 2、先生存   先启动1号消费者，在启动2号消费者， 问题：2号消费者能消费吗
         *  1号能够消费
         *  2号不能消费
         *  3、先启动两个消费者，请问，消费情况如何
         *   一人一半
         */
    }
}
