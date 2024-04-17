package baseEntities;

import configuration.ReadProperties;
import core.WaitsService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitsService = new WaitsService(driver);
    }

    protected abstract By getPageIdentifier();

    public Boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public String getPageUrl(){
        return ReadProperties.url();
    }
}
