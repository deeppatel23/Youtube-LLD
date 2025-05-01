package DecoratorDP.GoodCode;

abstract class NotificationDecorator implements NotificationSender {
    protected NotificationSender wrappedNotification;

    public NotificationDecorator(NotificationSender notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public String getMessage() {
        return wrappedNotification.getMessage();
    }

    @Override
    public void send() {
        wrappedNotification.send();
    }
}
