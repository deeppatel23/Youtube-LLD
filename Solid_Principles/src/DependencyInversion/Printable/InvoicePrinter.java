package DependencyInversion.Printable;

public class InvoicePrinter implements Printable {

    @Override
    public void process(double initialAmount, double discountAmount) {
        if (discountAmount <= 0) {
            throw new UnsupportedOperationException("Free invoices cannot be printed");
        }
        System.out.println("original amount is : " + initialAmount + " final invoice amount is : " + discountAmount);
    }
}
