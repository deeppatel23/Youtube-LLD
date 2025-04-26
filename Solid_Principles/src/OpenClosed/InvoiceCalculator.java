package OpenClosed;

import OpenClosed.Discount.DiscountStrategy;

class InvoiceCalculator {
    DiscountStrategy discount;

    InvoiceCalculator(DiscountStrategy discount) {
        this.discount = discount;
    }

    double calculateTotal(double baseAmount) {
        return discount.applyDiscount(baseAmount);
    }
}

