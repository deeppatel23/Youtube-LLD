package models;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Post {
    protected String text;
    protected User author;
    protected int votes = 0;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public Post(String text, User author) {
        this.text = text;
        this.author = author;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Common methods
    public void upvote() { votes++; }
    public int getVotes() { return votes; }
    public String getText() { return text; }
    public User getAuthor() { return author; }
}
