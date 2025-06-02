package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String role;
    List<Topic> subscribedTopics = new ArrayList<>();
    List<Question> questionsAsked = new ArrayList<>();
    List<Answer> answersGiven = new ArrayList<>();

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Topic> getSubscribedTopics() {
        return subscribedTopics;
    }

    public void setSubscribedTopics(List<Topic> subscribedTopics) {
        this.subscribedTopics = subscribedTopics;
    }

    public List<Question> getQuestionsAsked() {
        return questionsAsked;
    }

    public void setQuestionsAsked(List<Question> questionsAsked) {
        this.questionsAsked = questionsAsked;
    }

    public List<Answer> getAnswersGiven() {
        return answersGiven;
    }

    public void setAnswersGiven(List<Answer> answersGiven) {
        this.answersGiven = answersGiven;
    }
}
