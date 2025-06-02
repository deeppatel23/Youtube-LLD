package services;

import decorator.MultipleFeedFilterDecorator;
import enums.QuestionStatus;
import models.Question;
import models.Topic;
import models.User;
import strategy.FeedFilterStrategy;
import strategy.QuestionStatusBasedFilterStrategy;
import strategy.TagBasedFilterStrategy;

import java.util.ArrayList;
import java.util.List;

public class FeedService {
    public void showFeed() {
        System.out.println("---- Feed started ----");
        for (Question q : Database.questions.values()) {
            System.out.println(q.getText() + " [" + q.getStatus() + "]");
        }
        System.out.println("---- Feed ended ----");
    }

    public void showFeedByTopic(String topicName) {
        System.out.println("---- Feed by topic " + topicName + " started ----");
        List<Question> questions = getFilteredFeed(topicName, null);
        for (Question q : questions) {
            System.out.println(q.getText() + " [" + q.getStatus() + "]");
        }
        System.out.println("---- Feed ended ----");
    }

    public void showFeedAnswered(boolean answered) {
        System.out.println("---- Feed by answered = " + answered + " started ----");
        List<Question> questions = getFilteredFeed(null, answered);
        for (Question q : questions) {
            System.out.println(q.getText() + " [" + q.getStatus() + "]");
        }
        System.out.println("---- Feed ended ----");
    }

    private List<Question> getFilteredFeed(String topicName, Boolean isQuestionAnswered) {
        List<FeedFilterStrategy> strategies = new ArrayList<>();

        if (topicName != null) {
            Topic topic = TopicService.getOrCreateTopic(topicName);
            List<Topic>topics = new ArrayList<>();
            topics.add(topic);
            strategies.add(new TagBasedFilterStrategy(topics));
        }

        if (isQuestionAnswered != null) {
            strategies.add(new QuestionStatusBasedFilterStrategy(isQuestionAnswered ? QuestionStatus.ANSWERED : QuestionStatus.OPEN));
        }

        if (strategies.isEmpty()) {
            System.out.println("No questions to display! Please update the filters.");
            return new ArrayList<>();
        }

        FeedFilterStrategy multipleFilters = new MultipleFeedFilterDecorator(strategies);
        return multipleFilters.filter(Database.questions.values().stream().toList());
    }
}
