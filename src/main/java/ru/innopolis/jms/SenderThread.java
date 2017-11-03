package ru.innopolis.jms;

import javax.jms.JMSException;
import java.util.Scanner;

public class SenderThread extends Thread{
    private String queue;

    SenderThread(String queue){
        this.queue = queue;
    }
    public void run() {
        Sender sender = new Sender(queue);
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                sender.sendMessage(message);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

