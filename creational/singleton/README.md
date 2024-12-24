# Singleton Pattern

## What is the Singleton Pattern?
The Singleton Pattern ensures a class has only one instance throughout the application and provides a global point of access to that instance. This is useful for shared resources such as configuration settings, logging, caching, or database connections.

## Why use Singleton Pattern?
- To control concurrent access to a shared resource.
- To ensure there's only one instance of a resource-heavy class.
- To provide a global point of access to an object.

---

##  Code Example: Singleton for a Configuration Manager

```java
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConfigurationManager {
    // Volatile variable to ensure thread-safe access in multi-threaded scenarios
    private static volatile ConfigurationManager instance;
    private Properties properties;

    // Private constructor to restrict instantiation
    private ConfigurationManager() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Configuration file not found!");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    // Double-checked locking for thread-safe singleton initialization
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    // Method to retrieve configuration values
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Example setter for dynamic configurations (optional)
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}
```


## Usage Example

```java
public class SampleApp {
    public static void main(String[] args) {
        // Access the singleton instance
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Retrieve configuration properties
        String apiEndpoint = configManager.getProperty("api.endpoint");
        System.out.println("API Endpoint: " + apiEndpoint);

        // Update configuration dynamically
        configManager.setProperty("api.endpoint", "https://new-api.example.com");

        System.out.println("API Endpoint: " + apiEndpoint);
    }
}
```

## sample configuration

```
# config.properties

# API endpoint for the application
api.endpoint=https://api.example.com

# Database configuration
db.url=jdbc:mysql://localhost:3306/mydatabase
db.username=root
db.password=password

# Application settings
app.name=My Application
app.version=1.0.0
```