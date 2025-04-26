package DependencyInversion;

import DependencyInversion.Invoice.FreeInvoice;
import DependencyInversion.Invoice.Invoice;
import DependencyInversion.Invoice.PremiumInvoice;
import DependencyInversion.Invoice.StandardInvoice;

public class InvoiceManager {
    public static void main(String[] args) {
        Invoice invoice = new FreeInvoice(100);
        invoice.process();

        Invoice invoice1 = new PremiumInvoice(100);
        invoice1.process();

        Invoice invoice2 = new StandardInvoice(100);
        invoice2.process();
    }
}
