import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaminateTest {

    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = new BrowserService().getDriver();
    }

    @Test
    public void laminateAmountTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(2000);

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("650");
        Thread.sleep(1000);

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("500");
        Thread.sleep(1000);

        WebElement panelLength = driver.findElement(By.id("ln_lam_id"));
        panelLength.clear();
        panelLength.sendKeys("1500");
        Thread.sleep(1000);

        WebElement panelWidth = driver.findElement(By.id("wd_lam_id"));
        panelWidth.clear();
        panelWidth.sendKeys("350");
        Thread.sleep(1000);

        WebElement panelCount = driver.findElement(By.id("n_packing"));
        panelCount.clear();
        panelCount.sendKeys("15");
        Thread.sleep(1000);

        WebElement laminateLayingMethod = driver.findElement(By.id("laying_method_laminate"));
        Select dropDirection = new Select(laminateLayingMethod);
        dropDirection.selectByIndex(0);
        Thread.sleep(1000);

        WebElement laminateDirection = driver.findElement(By.id("direction-laminate-id1"));
        laminateDirection.click();

        WebElement calcButton = driver.findElement(By.className("calc-btn-div"));
        calcButton.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.className("calc-result")).getText().trim().replace("\r", ""),
                "Требуемое количество досок ламината: 67\n" +
                        "Количество упаковок ламината: 5\n" +
                        "Ниже представлена схема укладки ламината");

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
