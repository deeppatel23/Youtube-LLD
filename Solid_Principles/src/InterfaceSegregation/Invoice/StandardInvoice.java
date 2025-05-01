package InterfaceSegregation.Invoice;

import InterfaceSegregation.Discount.NoDiscount;
import InterfaceSegregation.InvoiceCalculator;
import InterfaceSegregation.InvoiceRepository;
import InterfaceSegregation.Printable.InvoicePrinter;
import InterfaceSegregation.Printable.Printable;

public class StandardInvoice extends Invoice {
    public StandardInvoice(int initialAmount) {
        super(initialAmount);
    }

    @Override
    public void process() {
        InvoiceCalculator calc = new InvoiceCalculator(new NoDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        Printable printer = new InvoicePrinter();
        printer.process(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }
}
