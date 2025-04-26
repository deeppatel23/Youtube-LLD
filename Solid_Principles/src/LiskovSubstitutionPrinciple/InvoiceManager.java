package LiskovSubstitutionPrinciple;

import LiskovSubstitutionPrinciple.Invoice.FreeInvoice;
import LiskovSubstitutionPrinciple.Invoice.Invoice;
import LiskovSubstitutionPrinciple.Invoice.PremiumInvoice;
import LiskovSubstitutionPrinciple.Invoice.StandardInvoice;

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
