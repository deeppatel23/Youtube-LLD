package decorator;

import models.Question;
import models.User;
import strategy.FeedFilterStrategy;

import java.util.List;

public class MultipleFeedFilterDecorator extends FeedFilterDecorator {
    private final List<FeedFilterStrategy> strategies;

    public MultipleFeedFilterDecorator(List<FeedFilterStrategy> strategies) {
        super(strategies.get(0)); // First strategy as base
        this.strategies = strategies;
    }

    @Override
    public List<Question> filter(List<Question> allQuestions) {
        List<Question> result = allQuestions;

        // Apply each strategy in sequence
        for (FeedFilterStrategy strategy : strategies) {
            result = strategy.filter(result);
        }

        return result;
    }
}
