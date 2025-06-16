package StateDP.GoodCode;

public class CardInsertedState implements ATMState {
    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("❌ Card already inserted.");
    }

    public void enterPin() {
        System.out.println("✅ PIN verified. You can now withdraw cash.");
        atm.setState(atm.getPinVerifiedState());
    }

    public void withdrawCash() {
        System.out.println("❌ Please enter PIN first.");
    }
}

