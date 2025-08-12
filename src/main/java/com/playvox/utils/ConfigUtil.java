package com.playvox.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Configuration utility class for reading properties
 */
public class ConfigUtil {
    
    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";
    
    static {
        loadProperties();
    }
    
    /**
     * Load properties from config file
     */
    private static void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            // If file doesn't exist, set default values
            setDefaultProperties();
        }
    }
    
    /**
     * Set default properties if config file is not found
     */
    private static void setDefaultProperties() {
        properties = new Properties();
        properties.setProperty("base.url", "https://rcktechiees-874988466824422142.myfreshworks.com");
        properties.setProperty("browser", "chrome");
        properties.setProperty("timeout", "10");
        properties.setProperty("test.email", "test@example.com");
        properties.setProperty("test.password", "password123");
    }
    
    /**
     * Get property value by key
     * @param key Property key
     * @return Property value
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    /**
     * Get base URL
     * @return Base URL
     */
    public static String getBaseUrl() {
        return getProperty("base.url");
    }
    
    /**
     * Get browser type
     * @return Browser type
     */
    public static String getBrowser() {
        return getProperty("browser");
    }
    
    /**
     * Get timeout value
     * @return Timeout in seconds
     */
    public static int getTimeout() {
        return Integer.parseInt(getProperty("timeout"));
    }
    
    /**
     * Get test email
     * @return Test email
     */
    public static String getTestEmail() {
        return getProperty("test.email");
    }
    
    /**
     * Get test password
     * @return Test password
     */
    public static String getTestPassword() {
        return getProperty("test.password");
    }
}