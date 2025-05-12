package AbstractFactoryDP.GoodCode;

public class AbstractUIFactory {

    public UIFactory getFactoryByOS(String os) {
        if (os.equalsIgnoreCase("windows")) {
            return new WindowsUIFactory();
        } else if (os.equalsIgnoreCase("mac")) {
            return new MacUIFactory();
        } else {
            throw new IllegalArgumentException("Unknown OS");
        }
    }
}
