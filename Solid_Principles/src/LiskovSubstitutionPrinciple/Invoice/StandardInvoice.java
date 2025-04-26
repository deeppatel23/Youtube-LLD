package LiskovSubstitutionPrinciple.Invoice;

import LiskovSubstitutionPrinciple.Discount.NoDiscount;
import LiskovSubstitutionPrinciple.InvoiceCalculator;
import LiskovSubstitutionPrinciple.Printable.InvoicePrinter;
import LiskovSubstitutionPrinciple.InvoiceRepository;

public class StandardInvoice extends Invoice{
    public StandardInvoice(int initialAmount) {
        super(initialAmount);
    }

    @Override
    public void process() {
        InvoiceCalculator calc = new InvoiceCalculator(new NoDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }
}
