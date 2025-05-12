package OpenClosed;

import OpenClosed.Discount.FullDiscount;
import OpenClosed.Discount.PremiumDiscount;

public class InvoiceManager {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(100);
        invoice.generateInvoiceNormal();

        Invoice invoice1 = new Invoice(100);
        invoice1.generateInvoicePremium();

        invoice.generateInvoiceFullDiscount();
    }
}
