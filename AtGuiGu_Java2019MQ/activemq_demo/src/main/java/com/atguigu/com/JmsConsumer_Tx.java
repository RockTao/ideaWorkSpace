package com.atguigu.com;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer_Tx {
    public static final String DEFAULT_BROKER_BIND_URL = "tcp://192.168.9.140:61616";
    public static final String QUERY_NAME = "tx01";


    public static void main(String[] args) throws JMSException, IOException {
        //1、创建连接工厂，按照给定的url地址,按照默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_BIND_URL);
        //2 、 通过连接工厂，获取指定的connetction
        Connection connnction = activeMQConnectionFactory.createConnection();
        connnction.start();
//         3、创建会话session   两个参数: 第一个叫事物  这二个叫签收
        Session session = connnction.createSession(true, Session.CLIENT_ACKNOWLEDGE);
//     4、创建目的地(具体是队列还是主题)
//        Destination --> 右键 Diagrams  ——> 右键 show  Impleations
        Queue queue = session.createQueue(QUERY_NAME);
// 5、创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        while (true){
            TextMessage textMessage= (TextMessage) messageConsumer.receive(4000L);

          if (null != textMessage){
              System.out.println("接受到的消息:" + textMessage.getText());
//              textMessage.acknowledge(); // 手动签收模式
          }else {
              break;
          }
        }
         messageConsumer.close();
        session.commit();// 事物为true是，commit之后才会改变消费的状态
         session.close();
         connnction.close();
    }
}
