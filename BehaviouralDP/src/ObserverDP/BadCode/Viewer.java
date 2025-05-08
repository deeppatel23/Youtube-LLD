package ObserverDP.BadCode;

class Viewer {
    private String name;

    public Viewer(String name) {
        this.name = name;
    }

    public void notify(String videoTitle) {
        System.out.println(name + " got notified: New video - " + videoTitle);
    }
}