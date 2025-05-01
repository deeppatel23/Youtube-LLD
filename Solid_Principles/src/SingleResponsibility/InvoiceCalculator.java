package SingleResponsibility;

class InvoiceCalculator {
    double calculateTotal(String customerType, int amount) {
        if(customerType.equals("REGULAR")) {
            return amount;
        } else if(customerType.equals("PREMIUM")) {
            // apply 10% discount
            return 0.9*amount;
        }
        return amount;
    }
}

