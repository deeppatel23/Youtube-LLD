package ObserverDP.GoodCode;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel {
    private List<Viewer> viewers = new ArrayList<>();

    public void subscribe(Viewer viewer) {
        viewers.add(viewer);
    }

    public void unsubscribe(Viewer viewer) {
        viewers.remove(viewer);
    }

    public void uploadVideo(String title) {
        System.out.println("Channel uploaded: " + title);
        for (Viewer v : viewers) {
            v.notify(title);
        }
    }
}
