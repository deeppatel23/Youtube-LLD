package AdapterDP.BadCode;

// Client code - has to handle different interfaces
class PaymentService {
    private UPIPaymentProcessor upiProcessor = new UPIPaymentProcessor();
    private CreditCardPaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();

    public void processPayment(String method, double amount, String identifier) {
        if ("upi".equals(method)) {
            upiProcessor.processPayment(amount, identifier); // PayPal email
        } else if ("creditcard".equals(method)) {
            // Need to convert amount to cents for Stripe!
            creditCardProcessor.charge(amount * 100, identifier); // Stripe token
        }
        // Adding another payment processor would require more if-else branches
    }

    public boolean verifyPayment(String method, String id) {
        if ("upi".equals(method)) {
            return upiProcessor.verifyPayment(id);
        } else if ("creditcard".equals(method)) {
            return creditCardProcessor.validateCharge(id);
        }
        return false;
    }
}
