import core.BrowserService;
import core.WaitsService;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static configuration.ReadProperties.getDownloadPath;

public class AdvancedActionsTest {

    protected WebDriver driver;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        waitsService = new WaitsService(driver);
    }

    @Test(testName = "Context Menu")
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement box = waitsService.waitForVisibility(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box)
                .build()
                .perform();

        Alert alert = waitsService.waitForAlert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();

    }

    @Test(testName = "Dynamic Controls")
    public void dynamicTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        waitsService.waitForVisibility(By.cssSelector("[onclick='swapCheckbox()']")).click();
        waitsService.waitForVisibility(By.cssSelector("#message"));
        Assert.assertTrue(waitsService.waitForInvisible(By.xpath("//button[text()='Remove']")));

        WebElement input = waitsService.waitForVisibility(By.cssSelector("input"));
        Assert.assertFalse(input.isEnabled());

        waitsService.waitForVisibility(By.cssSelector("[onclick='swapInput()']")).click();
        waitsService.waitForElementWithText(By.cssSelector("#message"), "It's enabled!");
        Assert.assertTrue(input.isEnabled());

    }

    @Test(testName = "File Upload")
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement uploadButton = waitsService.waitForVisibility(By.xpath("//input[@id='file-upload']"));
        String path = AdvancedActionsTest.class.getClassLoader().getResource("pexels-ian-turnell-709552.jpg")
                .getPath().substring(1);

        uploadButton.sendKeys(path);

        waitsService.waitForVisibility(By.xpath("//input[@id='file-submit']")).submit();
        Assert.assertEquals(waitsService.waitForVisibility(By.cssSelector("#uploaded-files"))
                .getText(), "pexels-ian-turnell-709552.jpg");
    }

    @Test
    public void FileDownloadTest() {
        driver.get("http://the-internet.herokuapp.com/download");
        List<WebElement> targetFiles = waitsService.waitForVisibilityOfAllElements
                (By.xpath("//a[contains(@href, '.png')]"));

        WebElement downloadFile = targetFiles.get(0);
        downloadFile.click();

        System.out.println("File to download:  " + downloadFile.getText());
        Boolean isDownloaded = waitsService.fluentWaitForDownload(downloadFile.getText());
        Assert.assertTrue(isDownloaded);
        new File(getDownloadPath(), downloadFile.getText()).deleteOnExit();
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }
}
