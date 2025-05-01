package LiskovSubstitutionPrinciple.Invoice;

import LiskovSubstitutionPrinciple.Discount.FullDiscount;
import LiskovSubstitutionPrinciple.InvoiceCalculator;
import LiskovSubstitutionPrinciple.Printable.InvoicePrinter;
import LiskovSubstitutionPrinciple.InvoiceRepository;

public class FreeInvoice extends Invoice{
    public FreeInvoice(int initialAmount) {
        super(initialAmount);
    }

    @Override
    public void process() {
        InvoiceCalculator calc = new InvoiceCalculator(new FullDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        InvoicePrinter printer = new InvoicePrinter();
        printer.preview(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }
}
