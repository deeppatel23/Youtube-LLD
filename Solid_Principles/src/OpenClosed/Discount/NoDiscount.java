package OpenClosed.Discount;

public class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount;
    }
}
