package OpenClosed;

import OpenClosed.Discount.FullDiscount;
import OpenClosed.Discount.NoDiscount;
import OpenClosed.Discount.PremiumDiscount;

public class Invoice {
    int initialAmount;

    Invoice(int initialAmount) {
        this.initialAmount = initialAmount;
    }
    void generateInvoiceNormal() {
        InvoiceCalculator calc = new InvoiceCalculator(new NoDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }

    void generateInvoicePremium() {
        InvoiceCalculator calc = new InvoiceCalculator(new PremiumDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }

    void generateInvoiceFullDiscount() {
        InvoiceCalculator calc = new InvoiceCalculator(new FullDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }
}
