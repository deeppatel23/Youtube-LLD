package FactoryDP.GoodCode;

class NotificationFactory {
    public Notification getNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) return new EmailNotification();
        if (type.equalsIgnoreCase("SMS")) return new SMSNotification();
        return null;
    }
}