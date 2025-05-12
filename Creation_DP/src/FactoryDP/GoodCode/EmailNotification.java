package FactoryDP.GoodCode;

class EmailNotification implements Notification {
    String senderEmail;

    public EmailNotification(String senderEmail) {
        this.senderEmail = senderEmail;
    }


    public void send() { System.out.println("Email sent"); }
}
