package ObserverDP.BadCode;

class YouTubeChannel {
    private String latestVideo;

    // Hardcoded, tightly coupled viewers
    private Viewer viewer1 = new Viewer("Alice");
    private Viewer viewer2 = new Viewer("Bob");

    public void uploadVideo(String title) {
        this.latestVideo = title;
        viewer1.notify(title);
        viewer2.notify(title);
    }
}