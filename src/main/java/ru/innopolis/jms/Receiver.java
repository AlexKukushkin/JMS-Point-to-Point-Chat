package ru.innopolis.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Receiver {

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageConsumer consumer = null;

    public Receiver(String queue) {
        factory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_BROKER_URL);
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            destination = session.createQueue(queue);
            consumer = session.createConsumer(destination);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage() throws JMSException {
        TextMessage message = (TextMessage)consumer.receive();
        System.out.println(message.getText());
    }

}
