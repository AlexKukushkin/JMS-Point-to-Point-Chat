package ru.innopolis.jms;

import javax.jms.JMSException;

public class ReceiverThread extends Thread{
    private String queue;

    ReceiverThread(String queue){
        this.queue = queue;
    }
    public void run() {
        Receiver receiver = new Receiver(queue);
        while (true) {
            try {
                receiver.receiveMessage();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

