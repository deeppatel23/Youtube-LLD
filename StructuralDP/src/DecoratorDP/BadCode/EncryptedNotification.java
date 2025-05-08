package DecoratorDP.BadCode;

class EncryptedNotification extends Notification {
    public EncryptedNotification(String message) {
        super(message);
    }

    @Override
    public void send() {
        String encrypted = encrypt(message);
        System.out.println("Sending encrypted notification: " + encrypted);
    }

    private String encrypt(String message) {
        // Encryption logic
        return "ENCRYPTED[" + message + "]";
    }
}
