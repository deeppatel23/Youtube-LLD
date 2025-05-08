package AdapterDP.GoodCode;

import AdapterDP.BadCode.UPIPaymentProcessor;

import java.util.HashMap;
import java.util.Map;

// Client code - has to handle different interfaces
class PaymentService {
    private Map<String, PaymentProcessor> processors = new HashMap<>();

    public PaymentService() {
        processors.put("upi", new UPIProcessor());
        processors.put("creditcard", new CreditCardProcessor());
    }

    public void processPayment(String method, double amount, String identifier) {
        processors.get(method).processPayment(amount, identifier);
    }

    public boolean verifyPayment(String method, String id) {
        return processors.get(method).verifyPayment(id);
    }
}
