package StrategyDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        CommutePlanner planner1 = new CommutePlanner(new Bike());
        planner1.planRoute(); // "Going by bike..."

        CommutePlanner planner2 = new CommutePlanner(new Metro());
        planner2.planRoute(); // "Taking the metro..."

    }
}
