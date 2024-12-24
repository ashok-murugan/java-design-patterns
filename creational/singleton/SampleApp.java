import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

class ConfigurationManager {
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