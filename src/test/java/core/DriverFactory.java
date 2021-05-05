package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static utils.PropertyReader.getBrowser;

public class DriverFactory {
    private static WebDriver driver;

    public void start() {
        if (driver == null) {
            switch (System.getProperty("browser", getBrowser())) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("kiosk"));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver((new FirefoxOptions().addArguments("--start-maximized")));
                    break;
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void finish() {
        driver.quit();
        driver = null;
    }

}
