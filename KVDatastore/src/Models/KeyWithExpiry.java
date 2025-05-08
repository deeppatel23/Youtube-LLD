package Models;

public class KeyWithExpiry {
    long createdTime;
    long expiryTime;

    public KeyWithExpiry (long expiryTime) {
        this.createdTime = System.currentTimeMillis();
        this.expiryTime = System.currentTimeMillis() + expiryTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}
