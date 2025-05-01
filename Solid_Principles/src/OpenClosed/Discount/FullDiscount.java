package OpenClosed.Discount;

public class FullDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount) {
        return 0;
    }
}
