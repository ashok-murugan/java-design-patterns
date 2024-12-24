// Cross-Platform UI Theme Factory

// Step 1: Define Abstract Products
// Button interface
interface Button {
    void render();
}

// Checkbox interface
interface Checkbox {
    void render();
}

// Step 2: Implement Concrete Products
// Windows-specific Button
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows Button");
    }
}
// MacOS-specific Button
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS Button");
    }
}

// Windows-specific Checkbox
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows Checkbox");
    }
}
// MacOS-specific Checkbox
class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a MacOS Checkbox");
    }
}

// Step 3: Define the Abstract Factory
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

//Step 4: Implement Concrete Factories
// Windows Factory
class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// MacOS Factory
class MacOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Example UIFactory usage
public class GUIApp {
    public static void main(String[] args) {
        // Choose the platform dynamically
        UIFactory uiFactory = getUIFactory("Windows"); // Change to "MacOS" for MacOS UI

        // Create UI components
        Button button = uiFactory.createButton();
        Checkbox checkbox = uiFactory.createCheckbox();

        // Render components
        button.render();
        checkbox.render();
    }

    // Factory chooser based on platform
    public static UIFactory getUIFactory(String osType) {
        switch (osType) {
            case "Windows":
                return new WindowsUIFactory();
            case "MacOS":
                return new MacOSUIFactory();
            default:
                throw new IllegalArgumentException("Unknown OS type: " + osType);
        }
    }
}