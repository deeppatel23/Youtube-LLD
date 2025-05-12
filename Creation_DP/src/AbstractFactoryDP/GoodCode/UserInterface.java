package AbstractFactoryDP.GoodCode;

public class UserInterface {

    public void createUI(UIFactory factory) {
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
