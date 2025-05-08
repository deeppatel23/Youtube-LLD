package LiskovSubstitutionPrinciple.Printable;

public interface Printable {
    void print(double initialAmount, double discountAmount);
    void preview(double initialAmount, double discountAmount);
}
