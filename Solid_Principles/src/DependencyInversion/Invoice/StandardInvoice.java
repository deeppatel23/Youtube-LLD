package DependencyInversion.Invoice;

import DependencyInversion.Discount.NoDiscount;
import DependencyInversion.InvoiceCalculator;
import DependencyInversion.InvoiceRepository;
import DependencyInversion.Printable.InvoicePrinter;
import DependencyInversion.Printable.Printable;
import DependencyInversion.Repository.MongoDatabase;

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

        InvoiceRepository repo = new InvoiceRepository(new MongoDatabase());
        repo.saveToDB();
    }
}
