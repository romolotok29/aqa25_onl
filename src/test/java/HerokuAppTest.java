import core.BrowserService;
import core.WaitsService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HerokuAppTest {

    protected WebDriver driver;
    protected WaitsService driverWait;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();
        driverWait = new WaitsService(driver);
    }

    @Test(testName = "iFrame")
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driverWait.waitForVisibility(By.cssSelector("a[href='/iframe']")).click();
        WebElement frameLocator = driverWait.waitForVisibility(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(frameLocator);
        Assert.assertEquals(driverWait.waitForVisibility(By.xpath("//p[text()='Your content goes here.']"))
                .getText(), "Your content goes here.");
    }

    @Test(testName = "Alert")
    public void promptAlertTest() {
        String text = "Hello, alert!";
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driverWait.waitForVisibility(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        Assert.assertEquals(driverWait.waitForVisibility(By.cssSelector("#result"))
                .getText(), ("You entered: " + text));

    }

    @Test(testName = "Windows")
    public void windowsTest() {
        driver.get("http://the-internet.herokuapp.com/windows");
        String originalWindowHandler = driver.getWindowHandle();
        WebElement link = driverWait.waitForVisibility(By.cssSelector("[href='/windows/new']"));
        int amountOfTabsExpected = 1;
        while (amountOfTabsExpected < 3) {
            amountOfTabsExpected++;
            link.click();
        }
        Set<String> handlersSet = driver.getWindowHandles();
        List<String> handlersList = new ArrayList<>(handlersSet);
        Assert.assertEquals(handlersList.size(), amountOfTabsExpected);
        driver.switchTo().window(handlersList.get((handlersList.size() - 1)));
        driver.close();
        handlersList.remove((handlersList.size() - 1));
        driver.switchTo().window(originalWindowHandler);
        Assert.assertEquals(handlersList.size(), amountOfTabsExpected - 1);
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }

}
