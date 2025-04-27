package AbstractFactoryDP.BadCode;

class Application {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface("windows");
        ui.createUI();

        UserInterface ui2 = new UserInterface("mac");
        ui2.createUI();
    }
}

