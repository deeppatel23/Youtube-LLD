package FactoryDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        notificationFactory.getNotification("Email").send();
        notificationFactory.getNotification("SMS").send();
        notificationFactory.getNotification("Email").send();
    }
}
