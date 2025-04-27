package AbstractFactoryDP.GoodCode;

public class Application {
    private static UIFactory getFactoryByOS(String os) {
        if (os.equals("windows")) {
            return new WindowsUIFactory();
        } else if (os.equals("mac os x")) {
            return new MacUIFactory();
        } else {
            throw new IllegalArgumentException("Unknown OS");
        }
    }

    public static void main(String[] args) {
        // Determine OS and get appropriate factory
        String currentOS = System.getProperty("os.name").toLowerCase();
        UIFactory factory = getFactoryByOS(currentOS);

        // Create UI with the factory
        UserInterface ui = new UserInterface(factory);
        ui.createUI();
    }
}
