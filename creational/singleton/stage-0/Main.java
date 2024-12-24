import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

class ConfigurationManager {
    private Properties properties;

    // Public constructor to allow multiple instances
    public ConfigurationManager() {
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

    // Method to retrieve configuration values
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Example setter for dynamic configurations (optional)
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new instance of ConfigurationManager
        ConfigurationManager configManager1 = new ConfigurationManager();

        // Retrieve configuration properties
        String apiEndpoint1 = configManager1.getProperty("api.endpoint");
        System.out.println("API Endpoint (Instance 1): " + apiEndpoint1);

        // Create another instance of ConfigurationManager
        ConfigurationManager configManager2 = new ConfigurationManager();

        // Retrieve configuration properties from the second instance
        String apiEndpoint2 = configManager2.getProperty("api.endpoint");
        System.out.println("API Endpoint (Instance 2): " + apiEndpoint2);

        // Update configuration dynamically in the first instance
        configManager1.setProperty("api.endpoint", "https://new-api.example.com");

        // The update will not reflect in the second instance since they are separate objects
        System.out.println("Updated API Endpoint (Instance 1): " + configManager1.getProperty("api.endpoint"));
        System.out.println("Original API Endpoint (Instance 2): " + configManager2.getProperty("api.endpoint"));
    }
}

