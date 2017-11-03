package ru.innopolis.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public Sender(String queue) {
        factory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_BROKER_URL);
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(queue);
            producer = session.createProducer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) throws JMSException {
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText(message);
        producer.send(textMessage);
    }
}
