package InterfaceSegregation;

import InterfaceSegregation.Discount.DiscountStrategy;

public class InvoiceCalculator {
    DiscountStrategy discount;

    public InvoiceCalculator(DiscountStrategy discount) {
        this.discount = discount;
    }

    public double calculateTotal(double baseAmount) {
        return discount.applyDiscount(baseAmount);
    }
}

