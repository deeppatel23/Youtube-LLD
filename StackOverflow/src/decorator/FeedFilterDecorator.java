package decorator;

import models.Question;
import models.User;
import strategy.FeedFilterStrategy;

import java.util.List;

public abstract class FeedFilterDecorator implements FeedFilterStrategy {
    protected final FeedFilterStrategy wrappedStrategy;

    public FeedFilterDecorator(FeedFilterStrategy strategy) {
        this.wrappedStrategy = strategy;
    }

    @Override
    public List<Question> filter(List<Question> allQuestions) {
        return wrappedStrategy.filter(allQuestions);
    }
}
