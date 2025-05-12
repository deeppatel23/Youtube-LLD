package SingleResponsibility;

class InvoiceCalculator {
    double calculateTotal(String customerType, int amount) {
        if(customerType.equals("REGULAR")) {
            return amount;
        } else if(customerType.equals("PREMIUM")) {
            // apply 10% discount
            return 0.9*amount;
        } else if (customerType.equals("SUPER_PREMIM")) {
            return 0.8*amount;

        }
        return amount;
    }
}

