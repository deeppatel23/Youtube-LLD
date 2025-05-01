package InterfaceSegregation.Invoice;

import InterfaceSegregation.Discount.FullDiscount;
import InterfaceSegregation.InvoiceCalculator;
import InterfaceSegregation.InvoiceRepository;
import InterfaceSegregation.Printable.InvoicePreview;
import InterfaceSegregation.Printable.Previewable;

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

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }
}
