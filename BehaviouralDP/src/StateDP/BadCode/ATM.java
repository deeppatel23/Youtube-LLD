package StateDP.BadCode;

public class ATM {
    private String state = "IDLE";

    public void insertCard() {
        if (state.equals("IDLE")) {
            System.out.println("💳 Card inserted. Please enter PIN.");
            state = "CARD_INSERTED";
        } else if (state.equals("CARD_INSERTED")) {
            System.out.println("<UNK> Card inserted. Please enter PIN.");
        } else if (state.equals("PIN_VERIFIED")) {
            System.out.println("<UNK> PIN verified. Please enter PIN.");
        }
        else {
            System.out.println("❌ Cannot insert card now.");
        }
    }

    public void enterPin() {
        if (state.equals("CARD_INSERTED")) {
            System.out.println("✅ PIN verified. You can now withdraw cash.");
            state = "PIN_VERIFIED";
        } else {
            System.out.println("❌ Invalid action at this stage.");
        }
    }

    public void withdrawCash() {
        if (state.equals("PIN_VERIFIED")) {
            System.out.println("💸 Cash withdrawn. Thank you!");
            state = "IDLE";
        } else {
            System.out.println("❌ You cannot withdraw now.");
        }
    }
}
