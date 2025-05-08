package AbstractFactoryDP.BadCode;

class UserInterface {
    private String operatingSystem; // "windows", "mac", or "linux"

    public UserInterface(String os) {
        this.operatingSystem = os;
    }

    public void createUI() {
        // Direct creation of OS-specific components scattered throughout the code
        // No separation between UI components and their creation logic

        if (operatingSystem.equalsIgnoreCase("windows")) {
            // Create Windows UI components
            WindowsButton button = new WindowsButton();
            WindowsCheckbox checkbox = new WindowsCheckbox();

            button.render();
            checkbox.render();
        }
        else if (operatingSystem.equalsIgnoreCase("mac")) {
            // Create Mac UI components
            MacButton button = new MacButton();
            MacCheckbox checkbox = new MacCheckbox();

            button.render();
            checkbox.render();
        }
        else if (operatingSystem.equalsIgnoreCase("linux")) {
            // Create Linux UI components
        }
        // Adding a new OS or UI component requires modifying this code
    }
}
