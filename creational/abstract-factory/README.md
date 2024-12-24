# Abstract Factory Pattern

## What is the Abstract Factory Pattern?
The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. It helps enforce a consistent theme or group of objects, making it particularly useful in cross-platform or configurable systems.

## Why use the Abstract Factory Pattern?
- To group related objects into families (e.g., UI components for different themes or platforms).
- To ensure compatibility among created objects.
- To follow the Open/Closed Principle by allowing extensions without modifying existing code.

##  Code Example: Cross-Platform UI Theme Factory

### Step 1: Define Abstract Products
```java
// Button interface
interface Button {
    void render();
}

// Checkbox interface
interface Checkbox {
    void render();
}
```

### Step 2: Implement Concrete Products
```java
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
```

### Step 3: Define the Abstract Factory
```java
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
```

### Step 4: Implement Concrete Factories
```java
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
```

### Usage Example
```java
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
```

## Benefits
- **Ensures consistency among related objects** (e.g., UI components look uniform).
- **Decouples client code** from specific concrete classes.
- **Simplifies the creation** of multiple object families.

## Pitfalls
- **Increases code complexity** by introducing additional layers of abstraction.
- **Adding new product types** to the family requires changes in all concrete factories.
