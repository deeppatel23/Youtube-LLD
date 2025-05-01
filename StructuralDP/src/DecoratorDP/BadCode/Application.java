package DecoratorDP.BadCode;

public class Application {
    public static void main(String[] args) {
        Notification notification = new Notification("notification");

        notification.send();

        EncryptedNotification encryptedNotification = new EncryptedNotification(notification.message);
        encryptedNotification.send();

        CompressedNotification compressedNotification = new CompressedNotification(notification.message);
        compressedNotification.send();

        EncryptedCompressedNotification encryptedCompressedNotification = new EncryptedCompressedNotification(notification.message);
        encryptedCompressedNotification.send();
    }
}
