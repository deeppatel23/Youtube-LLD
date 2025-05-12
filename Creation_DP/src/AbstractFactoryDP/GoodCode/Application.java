package AbstractFactoryDP.GoodCode;

public class Application {

    public static void main(String[] args) {
        AbstractUIFactory abstractUIFactory = new AbstractUIFactory();
        UserInterface ui = new UserInterface();

        ui.createUI(abstractUIFactory.getFactoryByOS("Windows"));
        ui.createUI(abstractUIFactory.getFactoryByOS("Mac"));
        ui.createUI(abstractUIFactory.getFactoryByOS("Windows"));
    }
}
