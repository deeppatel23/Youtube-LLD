package StrategyDP.GoodCode;

public class CommutePlanner {
    private TravelStrategy strategy;

    public CommutePlanner(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void planRoute() {
        strategy.go();
    }
}
