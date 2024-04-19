package configuration;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ReadProperties {

    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String browserName() {
        return properties.getProperty("browser");
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public static String getDownloadPath() {
        return ReadProperties.class.getClassLoader().getResource(properties.getProperty("downloadPath")).getPath();
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
}
