package main.java.com.kiaap.automation.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public final class ConfigManager {

    private static final String DEFAULT_CONFIG_FILE = "config.properties";
    private static final Properties PROPERTIES = loadProperties();

    private ConfigManager() {
        // utility class
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        String fileName = System.getProperty("config.file", DEFAULT_CONFIG_FILE);

        try {
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(fileName);

            if (inputStream != null) {
                try (InputStream stream = inputStream) {
                    properties.load(stream);
                }
            } else {
                Path path = Paths.get(fileName);
                if (Files.exists(path)) {
                    try (InputStream stream = Files.newInputStream(path)) {
                        properties.load(stream);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration file: " + fileName, e);
        }

        return properties;
    }

    public static String get(String key) {
        return get(key, null);
    }

    public static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value != null && !value.trim().isEmpty()) {
            return value;
        }
        value = PROPERTIES.getProperty(key);
        return value != null ? value : defaultValue;
    }

    public static int getInt(String key, int defaultValue) {
        String value = get(key);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static long getLong(String key, long defaultValue) {
        String value = get(key);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(value.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = get(key);
        if (value == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(value.trim());
    }

    public static String getBaseUrl() {
        return get("baseUrl", "https://example.com");
    }

    public static String getBrowser() {
        return get("browser", "chromium");
    }

    public static boolean isHeadless() {
        return getBoolean("headless", true);
    }

    public static int getTimeout() {
        return getInt("timeout", 30000);
    }

    public static String getEnvironment() {
        return get("environment", "QA");
    }

    public static String getUsername() {
        return get("username", "");
    }

    public static String getPassword() {
        return get("password", "");
    }
}
