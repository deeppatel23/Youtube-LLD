package InterfaceSegregation.Invoice;

public abstract class Invoice {
    int initialAmount;

    Invoice(int initialAmount) {
        this.initialAmount = initialAmount;
    }

    public abstract void process();
}
