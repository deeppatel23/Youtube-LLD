package services;

import enums.PostType;
import enums.QuestionStatus;
import factory.PostFactory;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class PostService {

    static int questionCounter = 0;

    public void addQuestion(String text, List<String> topics) {
        List<Topic>topicsList = new ArrayList<>();
        for (String topic : topics) {
            topicsList.add(TopicService.getOrCreateTopic(topic));
        }
        Post post = PostFactory.createPost(PostType.QUESTION, text, Database.currentUser, topicsList);
        Question question = (Question) post;
        questionCounter++;
        Database.questions.put(questionCounter, question);
        Database.currentUser.getQuestionsAsked().add(question);
        System.out.println("Question added: " + text);
    }

    public void answerQuestion(String questionText, String answerText) {
        Question question = null;
        for (Question q : Database.questions.values()) {
            if (q.getText().equals(questionText)) {
                List<Topic>topicsList = q.getTopics();
                List<Topic>subscribedTopics = Database.currentUser.getSubscribedTopics();
                for (Topic t : topicsList) {
                    if (!subscribedTopics.contains(t)) {
                        System.out.println("Topic not subscribed: " + t.getName() + " so the user cannot answer this question");
                        return;
                    }
                }
                question = q;
                break;
            }
        }
        if (question == null) {
            throw new IllegalArgumentException("Question not found: " + questionText);
        }

        Post post = PostFactory.createPost(PostType.ANSWER, answerText, Database.currentUser, question);
        Answer answer = (Answer) post;

        question.addAnswer(answer);
        Database.currentUser.getAnswersGiven().add(answer);
        System.out.println("Answer added: " + answerText + " for a question: " + questionText);
    }


    public void showQuestion(String questionText) {
        for (Question q : Database.questions.values()) {
            if (q.getText().equals(questionText)) {
                System.out.println("Q: " + q.getText());
                for (Answer ans : q.getAnswers()) {
                    System.out.println(" - " + ans.getText() + " by " + ans.getAuthor().getName() + (ans.isAccepted() ? " [Accepted]" : ""));
                }
                break;
            }
        }
    }

    public void acceptAnswer(String questionText, String answerText) {
        Question question = null;
        for (Question q : Database.questions.values()) {
            if (q.getText().equals(questionText)) {
                question = q;
                break;
            }
        }
        if (question == null) {
            System.out.println("Question not found: " + questionText);
            return;
        }
        if (!question.getAuthor().equals(Database.currentUser)) {
            System.out.println("Only asker can accept answers.");
            return;
        }
        for (Answer ans : question.getAnswers()) {
            if (ans.getText().equals(answerText)) {
                ans.markAccepted();
                question.acceptAnswer(ans);
                System.out.println("Answer accepted.");
                return;
            }
        }
        System.out.println("Answer not found.");
    }

    public void upvoteAnswer(String questionText, String answerText) {
        Question question = null;
        for (Question q : Database.questions.values()) {
            if (q.getText().equals(questionText)) {
                question = q;
                break;
            }
        }
        if (question == null) {
            System.out.println("Question not found: " + questionText);
            return;
        }
        for (Answer ans : question.getAnswers()) {
            if (ans.getText().equals(answerText)) {
                List<Topic>topicsList = ans.getQuestion().getTopics();
                List<Topic>subscribedTopics = Database.currentUser.getSubscribedTopics();
                for (Topic t : topicsList) {
                    if (!subscribedTopics.contains(t)) {
                        System.out.println("Topic not subscribed: " + t.getName() + " so the user cannot upvote this answer");
                        return;
                    }
                }
                ans.upvote();
                System.out.println("Answer upvoted.");
                return;
            }
        }
        System.out.println("Answer not found.");
    }
}
