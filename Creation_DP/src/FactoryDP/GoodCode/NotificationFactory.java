package FactoryDP.GoodCode;

class NotificationFactory {

    public Notification getNotification(String notificationType) {
        if (notificationType.equalsIgnoreCase("EMAIL")) return new EmailNotification("abc@gmail.com");
        if (notificationType.equalsIgnoreCase("SMS")) return new SMSNotification();
        return null;
    }
}