package InterfaceSegregation.Invoice;

import InterfaceSegregation.Discount.PremiumDiscount;
import InterfaceSegregation.InvoiceCalculator;
import InterfaceSegregation.InvoiceRepository;
import InterfaceSegregation.Printable.InvoicePrinter;
import InterfaceSegregation.Printable.Previewable;
import InterfaceSegregation.Printable.Printable;

public class PremiumInvoice extends Invoice {
    public PremiumInvoice(int initialAmount) {
        super(initialAmount);
    }

    @Override
    public void process() {
        InvoiceCalculator calc = new InvoiceCalculator(new PremiumDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        Printable printer = new InvoicePrinter();
        printer.process(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }
}
