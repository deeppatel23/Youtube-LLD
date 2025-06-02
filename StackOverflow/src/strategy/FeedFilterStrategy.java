package strategy;

import models.Question;
import models.User;

import java.util.List;

public interface FeedFilterStrategy {
    List<Question> filter(List<Question> allQuestions);
}
