package LiskovSubstitutionPrinciple.Printable;

public class InvoicePrinter implements Printable {

    @Override
    public void print(double initialAmount, double discountAmount) {
        if (discountAmount <= 0) {
            throw new UnsupportedOperationException("Free invoices cannot be printed");
        }
        System.out.println("original amount is : " + initialAmount + " final invoice amount is : " + discountAmount);
    }

    @Override
    public void preview(double initialAmount, double discountAmount) {
        System.out.println("Preview original amount is : " + initialAmount + " final invoice amount is : " + discountAmount);
    }
}
