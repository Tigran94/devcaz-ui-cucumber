package utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static final Properties properties = new Properties();
    private static String URL;
    private static String BROWSER;

    @SneakyThrows
    public static void load() {
        InputStream inputStream = new FileInputStream("src/test/resources/config/app.properties");
        properties.load(inputStream);
        URL = System.getProperty("url", properties.getProperty("url"));
        BROWSER = System.getProperty("browser", properties.getProperty("browser"));
    }

    public static String getBrowser() {
        return BROWSER;
    }

    public static String getURL() {
        return URL;
    }

}
