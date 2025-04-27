package AbstractFactoryDP.GoodCode;

public class UserInterface {
    private UIFactory factory;

    public UserInterface(UIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
