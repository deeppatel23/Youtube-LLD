package LiskovSubstitutionPrinciple.Invoice;

import LiskovSubstitutionPrinciple.Discount.PremiumDiscount;
import LiskovSubstitutionPrinciple.InvoiceCalculator;
import LiskovSubstitutionPrinciple.Printable.InvoicePrinter;
import LiskovSubstitutionPrinciple.InvoiceRepository;

public class PremiumInvoice extends Invoice{
    public PremiumInvoice(int initialAmount) {
        super(initialAmount);
    }

    @Override
    public void process() {
        InvoiceCalculator calc = new InvoiceCalculator(new PremiumDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }
}
