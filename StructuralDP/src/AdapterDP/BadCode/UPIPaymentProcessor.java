package AdapterDP.BadCode;

public class UPIPaymentProcessor {
    public void processPayment(double amount, String email) {
        // UPI specific implementation
        System.out.println("Processing $" + amount + " UPI payment for " + email);
        // API calls to UPI
    }

    public boolean verifyPayment(String transactionId) {
        // PayPal specific verification
        System.out.println("Verifying UPI payment: " + transactionId);
        return true;
    }
}
