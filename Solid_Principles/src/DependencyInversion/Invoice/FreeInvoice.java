package DependencyInversion.Invoice;

import DependencyInversion.Discount.FullDiscount;
import DependencyInversion.InvoiceCalculator;
import DependencyInversion.InvoiceRepository;
import DependencyInversion.Printable.InvoicePreview;
import DependencyInversion.Printable.Previewable;
import DependencyInversion.Repository.MongoDatabase;
import DependencyInversion.Repository.MySQLDatabase;

public class FreeInvoice extends Invoice {
    public FreeInvoice(int initialAmount) {
        super(initialAmount);
    }

    @Override
    public void process() {
        InvoiceCalculator calc = new InvoiceCalculator(new FullDiscount());
        double discountAmount = calc.calculateTotal( initialAmount);

        Previewable preview = new InvoicePreview();
        preview.process(initialAmount, discountAmount);

        InvoiceRepository repo = new InvoiceRepository(new MongoDatabase());
        repo.saveToDB();
    }
}
