package DecoratorDP.GoodCode;

class CompressionDecorator extends NotificationDecorator {
    public CompressionDecorator(NotificationSender notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return compress(wrappedNotification.getMessage());
    }

    @Override
    public void send() {
        System.out.println("Sending compressed notification: " + getMessage());
    }

    private String compress(String message) {
        // Compression logic
        return "COMPRESSION[" + message + "]";
    }
}
