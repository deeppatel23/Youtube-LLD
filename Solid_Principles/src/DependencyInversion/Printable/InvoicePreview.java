package DependencyInversion.Printable;

public class InvoicePreview implements Previewable {
    @Override
    public void process(double initialAmount, double discountAmount) {
        System.out.println("Preview original amount is : " + initialAmount + " final invoice amount is : " + discountAmount);
    }
}
