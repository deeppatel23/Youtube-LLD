package DecoratorDP.BadCode;

public class EncryptedCompressedNotification extends Notification{
    public EncryptedCompressedNotification(String message) {
        super(message);
    }

    @Override
    public void send() {
        String compressed = encrypt(compress(message));
        System.out.println("Sending encrypted-compressed notification: " + compressed);
    }

    private String compress(String message) {
        // Compression logic
        return "COMPRESSED[" + message + "]";
    }

    private String encrypt(String message) {
        // Encryption logic
        return "ENCRYPTED[" + message + "]";
    }
}
