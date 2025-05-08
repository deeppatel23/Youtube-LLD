package DecoratorDP.GoodCode;

public class NotificationService {
    public void sendNotification(String message, boolean encrypted, boolean compressed) {
        NotificationSender notification = new BasicNotification(message);

        // Dynamically add decorators based on requirements
        if (encrypted) {
            notification = new EncryptionDecorator(notification);
        }
        if (compressed) {
            notification = new CompressionDecorator(notification);
        }

        // Send the decorated notification
        notification.send();
    }

}
