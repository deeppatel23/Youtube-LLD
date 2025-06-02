package factory;

import enums.PostType;
import models.*;

import java.util.List;

public class PostFactory {

    public static Post createPost(PostType postType, String text, User author, Object... args) {
        return switch (postType) {
            case QUESTION -> {
                @SuppressWarnings("unchecked")
                List<Topic> topics = (List<Topic>) args[0];
                yield new Question(text, author, topics);
            }
            case ANSWER -> {
                Question question = (Question) args[0];
                yield new Answer(text, author, question);
            }
            default -> throw new IllegalArgumentException("Unsupported PostType: " + postType);
        };
    }
}

