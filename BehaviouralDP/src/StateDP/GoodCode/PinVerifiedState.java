package StateDP.GoodCode;

public class PinVerifiedState implements ATMState {
    private ATM atm;

    public PinVerifiedState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("❌ Transaction in progress.");
    }

    public void enterPin() {
        System.out.println("❌ PIN already verified.");
    }

    public void withdrawCash() {
        System.out.println("💸 Cash withdrawn. Thank you!");
        atm.setState(atm.getIdleState());
    }
}

