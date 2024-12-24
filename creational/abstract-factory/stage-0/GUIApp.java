// Windows-specific Button
class WindowsButton {
    public void render() {
        System.out.println("Rendering a Windows Button");
    }
}

// MacOS-specific Button
class MacOSButton {
    public void render() {
        System.out.println("Rendering a MacOS Button");
    }
}

// Windows-specific Checkbox
class WindowsCheckbox {
    public void render() {
        System.out.println("Rendering a Windows Checkbox");
    }
}

// MacOS-specific Checkbox
class MacOSCheckbox {
    public void render() {
        System.out.println("Rendering a MacOS Checkbox");
    }
}

public class Main {
    public static void main(String[] args) {
        // Directly create UI components based on platform
        String osType = "Windows"; // Can be changed to "MacOS"

        if (osType.equals("Windows")) {
            WindowsButton button = new WindowsButton();
            WindowsCheckbox checkbox = new WindowsCheckbox();
            button.render();
            checkbox.render();
        } else if (osType.equals("MacOS")) {
            MacOSButton button = new MacOSButton();
            MacOSCheckbox checkbox = new MacOSCheckbox();
            button.render();
            checkbox.render();
        } else {
            throw new IllegalArgumentException("Unknown OS type: " + osType);
        }
    }
}
