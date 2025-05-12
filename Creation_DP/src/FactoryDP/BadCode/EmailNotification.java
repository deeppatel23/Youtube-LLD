package FactoryDP.BadCode;

public class EmailNotification {

    String senderEmail;

    public EmailNotification(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public void send() {
        System.out.println("Email is sent");
    }
}
