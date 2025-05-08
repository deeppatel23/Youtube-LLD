package ObserverDP.GoodCode;

public class Subscriber implements Viewer{
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void notify(String videoTitle) {
        System.out.println(name + " got notified: New video - " + videoTitle);
    }
}
