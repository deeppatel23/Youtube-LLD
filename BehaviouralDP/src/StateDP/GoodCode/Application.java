package StateDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.insertCard();
        atm.withdrawCash();
        atm.enterPin();
        atm.withdrawCash();
    }
}
