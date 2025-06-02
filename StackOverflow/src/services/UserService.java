package services;

import models.Topic;
import models.User;

public class UserService {
    public void subscribe(String... topicNames) {
        System.out.println("User subscribed to topics: " + String.join(", ", topicNames));
        for (String name : topicNames) {
            Topic t = TopicService.getOrCreateTopic(name);
            Database.currentUser.getSubscribedTopics().add(t);
        }
    }

    public void showProfile(String name) {
        User user = Database.users.get(name);
        System.out.println("Profile of " + name);
        System.out.println("Questions: " + user.getQuestionsAsked().size());
        System.out.println("Answers: " + user.getAnswersGiven().size());
    }
}
