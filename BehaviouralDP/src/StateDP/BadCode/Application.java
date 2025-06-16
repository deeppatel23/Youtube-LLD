package StateDP.BadCode;

public class Application {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.insertCard();
        atm.enterPin();
        atm.insertCard();
        atm.withdrawCash();
    }
}
