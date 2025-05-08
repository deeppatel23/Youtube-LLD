package AdapterDP.GoodCode;


public class Application {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("upi", 100.01, "upi_1");
        paymentService.verifyPayment("upi", "upi_1");

        paymentService.processPayment("creditcard", 100.02, "cc_1");
        paymentService.verifyPayment("creditcard", "cc_1");
    }
}
