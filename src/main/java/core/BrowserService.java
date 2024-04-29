package core;

import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;

import static configuration.ReadProperties.getDownloadPath;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType;

    public BrowserService() {
        switch (ReadProperties.browserName().toLowerCase()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "safari":
                driverManagerType = DriverManagerType.SAFARI;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Browser " + ReadProperties.browserName() + " is not supported");
                break;

        }
    }

    public WebDriver getDriver() {
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        return driver;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--incognito");
        HashMap<String, Object> preference = new HashMap<>();
        preference.put("profile.default_content_settings.popups", 0);
        preference.put("download.default_directory", getDownloadPath());
        chromeOptions.setExperimentalOption("prefs", preference);
        return chromeOptions;

    }
}
