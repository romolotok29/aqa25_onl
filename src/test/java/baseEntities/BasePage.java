package baseEntities;

import configuration.ReadProperties;
import core.WaitsService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this(driver, false);
    }

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        this.waitsService = new WaitsService(driver);

        if (openPageByUrl) {
            openPageByUrl();
        }
    }

    protected abstract By getPageIdentifier();
    protected abstract String getPagePath();


    public Boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public String openPageByUrl(){
        return ReadProperties.url() + getPagePath();
    }
}
