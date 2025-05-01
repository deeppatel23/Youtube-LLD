package DecoratorDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("notification", true, false );
        notificationService.sendNotification("notification", false, true );
        notificationService.sendNotification("notification", true, true );
    }
}
