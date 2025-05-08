package AdapterDP.GoodCode;

public class CreditCardPaymentProcessor {
    public void charge(double amountInCents, String stripeToken) {
        System.out.println("Charging " + (amountInCents/100) + " using CC token: " + stripeToken);
        // API calls to Credit card company
    }

    public boolean validateCharge(String chargeId) {
        // Stripe specific validation
        System.out.println("Validating CC charge: " + chargeId);
        return true;
    }
}
