package models;

import enums.QuestionStatus;

import java.util.ArrayList;
import java.util.List;

public class Question extends Post {
    private List<Topic> topics;
    private List<Answer> answers = new ArrayList<>();
    private Answer acceptedAnswer;

    public Question(String text, User author, List<Topic> topics) {
        super(text, author);
        this.topics = topics;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void acceptAnswer(Answer answer) {
        this.acceptedAnswer = answer;
    }

    public List<Topic> getTopics() { return topics; }
    public List<Answer> getAnswers() { return answers; }
    public Answer getAcceptedAnswer() { return acceptedAnswer; }

    public QuestionStatus getStatus() {
        return acceptedAnswer == null ? QuestionStatus.OPEN : QuestionStatus.ANSWERED;
    }
}
