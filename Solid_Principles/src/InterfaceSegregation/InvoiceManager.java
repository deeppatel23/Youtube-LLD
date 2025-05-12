package InterfaceSegregation;


import InterfaceSegregation.Invoice.*;
import InterfaceSegregation.Invoice.Invoice;

public class InvoiceManager {
    public static void main(String[] args) {
        Invoice invoice = new FreeInvoice(100);
        invoice.process();

        invoice = new PremiumInvoice(100);
        invoice.process();

        invoice = new StandardInvoice(100);
        invoice.process();
    }
}
