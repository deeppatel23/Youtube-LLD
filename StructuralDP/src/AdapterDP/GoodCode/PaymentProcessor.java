package AdapterDP.GoodCode;

public interface PaymentProcessor {
    void processPayment(double amount, String paymentDetails);
    boolean verifyPayment(String transactionId);
}
