package FactoryDP.GoodCode;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification notify = factory.getNotification("EMAIL");
        notify.send();

        Notification notify2 = factory.getNotification("SMS");
        notify2.send();
    }
}
