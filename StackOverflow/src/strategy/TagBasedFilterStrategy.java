package strategy;

import models.Question;
import models.Topic;
import models.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TagBasedFilterStrategy implements FeedFilterStrategy {
    private final List<Topic> topics;

    public TagBasedFilterStrategy(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public List<Question> filter(List<Question> allQuestions) {
        return allQuestions.stream()
                .filter(q -> !Collections.disjoint(q.getTopics(), topics))
                .collect(Collectors.toList());
    }
}
