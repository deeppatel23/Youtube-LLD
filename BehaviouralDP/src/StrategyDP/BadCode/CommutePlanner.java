package StrategyDP.BadCode;

public class CommutePlanner {
    public void goToOffice(String method) {
        if (method.equals("bike")) {
            System.out.println("Going by bike...");
        } else if (method.equals("car")) {
            System.out.println("Going by car...");
        } else if (method.equals("metro")) {
            System.out.println("Taking the metro...");
        }
    }
}
