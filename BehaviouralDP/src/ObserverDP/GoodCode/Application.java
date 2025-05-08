package ObserverDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        YouTubeChannel youTubeChannel = new YouTubeChannel();

        Viewer viewer1 = new Subscriber("Alice");
        youTubeChannel.subscribe(viewer1);
        youTubeChannel.uploadVideo("Observer Pattern Explained");

        Viewer viewer2 = new Subscriber("Bob");
        youTubeChannel.subscribe(viewer2);
        youTubeChannel.uploadVideo("LLD QnA");
    }
}
