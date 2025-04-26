package SingleResponsibility;

public class Invoice {
    void generateInvoice() {
        InvoiceCalculator calc = new InvoiceCalculator();
        double total = calc.calculateTotal("PREMIUM", 100);

        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(total);

        InvoiceRepository repo = new InvoiceRepository();
        repo.saveToDB();
    }
}
