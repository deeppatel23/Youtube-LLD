package DependencyInversion.Invoice;

import DependencyInversion.Discount.PremiumDiscount;
import DependencyInversion.InvoiceCalculator;
import DependencyInversion.InvoiceRepository;
import DependencyInversion.Printable.InvoicePrinter;
import DependencyInversion.Printable.Printable;
import DependencyInversion.Repository.MySQLDatabase;

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

        InvoiceRepository repo = new InvoiceRepository(new MySQLDatabase());
        repo.saveToDB();
    }
}
