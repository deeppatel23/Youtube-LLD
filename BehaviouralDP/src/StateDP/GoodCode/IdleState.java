package StateDP.GoodCode;

public class IdleState implements ATMState {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("💳 Card inserted. Please enter PIN.");
        atm.setState(atm.getCardInsertedState());
    }

    public void enterPin() {
        System.out.println("❌ Please insert card first.");
    }

    public void withdrawCash() {
        System.out.println("❌ Insert card and enter PIN first.");
    }
}

