package DecoratorDP.GoodCode;

class BasicNotification implements NotificationSender {
    private String message;

    public BasicNotification(String message) {
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending notification: " + message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
