package core;

import configuration.ReadProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static configuration.ReadProperties.getDownloadPath;

public class WaitsService {

    private WebDriverWait wait;
    private WebDriver driver;
    private Duration timeout;

    public WaitsService(WebDriver driver) {
        this.driver = driver;
        timeout = Duration.ofSeconds(ReadProperties.getTimeout());
        wait = new WebDriverWait(driver, timeout);
    }

    public WaitsService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public List<WebElement> waitForVisibilityAllElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public boolean waitForInvisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public Boolean fluentWaitForDownload(String fileName) {
        File targetFile = new File(getDownloadPath(), fileName);
        Wait<File> fluent = new FluentWait<>(targetFile)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(RuntimeException.class)
                .withMessage("No such file");
        return fluent.until(downloadedFile -> targetFile.exists());
    }

    public WebElement waitForElementWithText(By locator, String text) {
        if (wait.until(ExpectedConditions.textToBe(locator, text))) {
            return waitForVisibility(locator);
        }
        return null;
    }
}
