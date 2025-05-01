package AdapterDP.GoodCode;

public class UPIProcessor implements PaymentProcessor{

    UPIPaymentProcessor upiPaymentProcessor = new UPIPaymentProcessor();

    @Override
    public void processPayment(double amount, String paymentDetails) {
        upiPaymentProcessor.processPayment(amount, paymentDetails);
    }

    @Override
    public boolean verifyPayment(String transactionId) {
        return upiPaymentProcessor.verifyPayment(transactionId);
    }
}
