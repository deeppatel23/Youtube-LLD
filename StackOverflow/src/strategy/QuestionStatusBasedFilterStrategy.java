package strategy;

import enums.QuestionStatus;
import models.Question;
import models.User;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionStatusBasedFilterStrategy implements FeedFilterStrategy{

    private final QuestionStatus questionStatus;

    public QuestionStatusBasedFilterStrategy(QuestionStatus questionStatus) {
        this.questionStatus = questionStatus;
    }

    @Override
    public List<Question> filter(List<Question> allQuestions) {
        return allQuestions.stream()
                .filter(q -> q.getStatus().equals(questionStatus))
                .collect(Collectors.toList());
    }
}
