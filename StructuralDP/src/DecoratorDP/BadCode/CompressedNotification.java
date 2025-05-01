package DecoratorDP.BadCode;

class CompressedNotification extends Notification {
    public CompressedNotification(String message) {
        super(message);
    }

    @Override
    public void send() {
        String compressed = compress(message);
        System.out.println("Sending compressed notification: " + compressed);
    }

    private String compress(String message) {
        // Compression logic
        return "COMPRESSED[" + message + "]";
    }
}
