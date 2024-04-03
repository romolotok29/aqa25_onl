import core.BrowserService;
import core.WaitsService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    protected WaitsService wait;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        wait = new WaitsService(driver);
    }

    @Test(testName = "Context Menu")
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement box = wait.waitForVisibility(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box)
                .build()
                .perform();
        Alert alert = wait.waitForAlert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();

    }

    @Test(testName = "Dynamic Controls")
    public void dynamicTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        wait.waitForVisibility(By.cssSelector("[onclick='swapCheckbox()']")).click();
        wait.waitForVisibility(By.cssSelector("#message"));
        Assert.assertTrue(wait.waitForInvisible(By.xpath("//button[text()='Remove']")));
        WebElement input = wait.waitForVisibility(By.cssSelector("input"));
        Assert.assertFalse(input.isEnabled());
        wait.waitForVisibility(By.cssSelector("[onclick='swapInput()']")).click();
        wait.waitForElementWithText(By.cssSelector("#message"), "It's enabled!");
        Assert.assertTrue(input.isEnabled());

    }

    @Test(testName = "File Upload")
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement uploadBtn = wait.waitForVisibility(By.cssSelector("#file-upload"));
        String path = AdvancedActionsTest.class.getClassLoader().getResource("streetTest.jpeg").getPath();
        uploadBtn.sendKeys(path);
        wait.waitForVisibility(By.cssSelector("#file-submit")).submit();
        Assert.assertEquals(wait.waitForVisibility(By.cssSelector("#uploaded-files")).getText(), "streetTest.jpeg");
    }

    @Test(testName = "File Download")
    public void fileDownloadTest() {
        driver.get("http://the-internet.herokuapp.com/download");
        List<WebElement> targetFiles = wait.waitForVisibilityAllElements(By.xpath("//a[contains(@href, '.png')]"));
        WebElement downloadFile = targetFiles.get(0);
        downloadFile.click();
        System.out.println("File to download:  " + downloadFile.getText());
        Boolean isDownloaded = wait.fluentWaitForDownload(downloadFile.getText());
        System.out.println("Successful download: " + isDownloaded);
        File folder = new File(getDownloadPath());
        File[] folderContent = folder.listFiles();
        boolean hasDownloadedFile = false;
        for (File fileFromFolder : folderContent) {
            if (fileFromFolder.isFile()) {
                String fileName = fileFromFolder.getName();
                if (fileName.equals(downloadFile.getText())) {
                    hasDownloadedFile = true;
                }
            }
        }
        Assert.assertTrue(hasDownloadedFile);
        folder.deleteOnExit();
        new File(getDownloadPath(), downloadFile.getText()).deleteOnExit();
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }


}
