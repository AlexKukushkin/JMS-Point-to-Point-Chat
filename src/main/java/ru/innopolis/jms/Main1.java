package ru.innopolis.jms;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Client 1 is connected :");
        System.out.println("-----------------------");
        new Thread(new ReceiverThread("Queue1")).start();
        new Thread(new SenderThread("Queue2")).start();
    }
}
