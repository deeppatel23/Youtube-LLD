package models;

public class Answer extends Post {
    private Question question;
    private boolean isAccepted = false;

    public Answer(String text, User author, Question question) {
        super(text, author);
        this.question = question;
    }

    public void markAccepted() {
        this.isAccepted = true;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Question getQuestion() {
        return question;
    }
}
