package ru.innopolis.jms;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Client 2 is connected :");
        System.out.println("-----------------------");
        new Thread(new ReceiverThread("Queue2")).start();
        new Thread(new SenderThread("Queue1")).start();
    }
}
