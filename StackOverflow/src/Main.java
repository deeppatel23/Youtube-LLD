import services.*;

import java.util.Arrays;

public class Main {
    static AuthService authService = new AuthService();
    static UserService userService = new UserService();
    static PostService postService = new PostService();
    static FeedService feedService = new FeedService();

    public static void main(String[] args) {
        authService.signup("Sachin", "Developer");
        userService.subscribe("java", "hadoop", "jdk");
        postService.addQuestion("What are new open source jdks?", Arrays.asList("java", "jdk"));
        postService.addQuestion("Does Hadoop work on JDK 11?", Arrays.asList("hadoop", "jdk"));
        feedService.showFeed();
        feedService.showFeedByTopic("java");
        feedService.showFeedByTopic("jdk");
        feedService.showFeedAnswered(true);
        authService.logout();

        authService.signup("Kalyan", "Developer");
        userService.subscribe("apache", "hadoop");
        feedService.showFeed();
        postService.addQuestion("Does Apache Spark support streaming of data from hdfs?", Arrays.asList("apache", "hadoop"));
        postService.answerQuestion("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");
        userService.subscribe("java", "jdk");
        postService.answerQuestion("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");
        feedService.showFeed();
        authService.logout();

        authService.signup("Lokesh", "Developer");
        userService.subscribe("apache", "hadoop", "java");
        feedService.showFeed();
        postService.showQuestion("Does Hadoop work on JDK 11?");
        postService.acceptAnswer("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");
        postService.upvoteAnswer("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");
        userService.subscribe("jdk");
        postService.upvoteAnswer("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");
        authService.logout();

        authService.login("Sachin");
        feedService.showFeed();
        userService.showProfile("Kalyan");
        postService.showQuestion("Does Hadoop work on JDK 11?");
        postService.acceptAnswer("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");
        userService.showProfile("Kalyan");
        feedService.showFeedAnswered(true);
        feedService.showFeedAnswered(false);
        authService.logout();
    }
}