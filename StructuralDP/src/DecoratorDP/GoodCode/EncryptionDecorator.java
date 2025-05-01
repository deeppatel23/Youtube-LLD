package DecoratorDP.GoodCode;

class EncryptionDecorator extends NotificationDecorator {
    public EncryptionDecorator(NotificationSender notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return encrypt(wrappedNotification.getMessage());
    }

    @Override
    public void send() {
        System.out.println("Sending encrypted notification: " + getMessage());
    }

    private String encrypt(String message) {
        // Encryption logic
        return "ENCRYPTED[" + message + "]";
    }
}
