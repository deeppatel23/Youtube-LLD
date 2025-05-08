package DecoratorDP.BadCode;

class Notification {
    protected String message;

    public Notification(String message) {
        this.message = message;
    }

    public void send() {
        System.out.println("Sending notification: " + message);
    }
}
