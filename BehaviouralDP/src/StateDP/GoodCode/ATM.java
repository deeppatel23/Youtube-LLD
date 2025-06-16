package StateDP.GoodCode;

public class ATM {
    private ATMState idleState;
    private ATMState cardInsertedState;
    private ATMState pinVerifiedState;
    private ATMState nextState;

    private ATMState currentState;

    public ATM() {
        idleState = new IdleState(this);
        cardInsertedState = new CardInsertedState(this);
        pinVerifiedState = new PinVerifiedState(this);
        currentState = idleState;
    }

    public void setState(ATMState state) {
        currentState = state;
    }

    public ATMState getIdleState() {
        return idleState;
    }

    public ATMState getCardInsertedState() {
        return cardInsertedState;
    }

    public ATMState getPinVerifiedState() {
        return pinVerifiedState;
    }

    public void insertCard() {
        currentState.insertCard();
    }

    public void enterPin() {
        currentState.enterPin();
    }

    public void withdrawCash() {
        currentState.withdrawCash();
    }
}

