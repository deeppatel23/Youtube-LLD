package AdapterDP.GoodCode;

public class CreditCardProcessor implements PaymentProcessor{

    CreditCardPaymentProcessor creditCardPaymentProcessor = new CreditCardPaymentProcessor();

    @Override
    public void processPayment(double amount, String paymentDetails) {
        creditCardPaymentProcessor.charge(amount, paymentDetails);
    }

    @Override
    public boolean verifyPayment(String transactionId) {
        return creditCardPaymentProcessor.validateCharge(transactionId);
    }
}
