import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BymedTest {

    private WebDriver driver;

    @BeforeMethod
    public void browserSetup() {
        driver = new BrowserService().getDriver();
    }

    @Test
    public void browserCalcTest() throws InterruptedException {
        driver.get("https://bymed.top/calc/%D1%81%D0%BA%D1%84-2148");
        Thread.sleep(3000);
        driver.switchTo().frame(1);

        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("23");

        WebElement sexSelectElement = driver.findElement(By.id("sex"));
        Select sexDropdown = new Select(sexSelectElement);
        sexDropdown.selectByIndex(0);

        WebElement creatinine = driver.findElement(By.id("cr"));
        creatinine.sendKeys("80");

        WebElement weight = driver.findElement(By.id("mass"));
        weight.sendKeys("70");

        WebElement height = driver.findElement(By.id("grow"));
        height.sendKeys("180");

        WebElement calcButton = driver.findElement(By.xpath("//button[contains(text(), 'Рассчитать')]"));
        calcButton.click();

        WebElement mdrdResult = driver.findElement(By.id("mdrd"));
        WebElement cgeResult = driver.findElement(By.id("cge"));
        Thread.sleep(2000);

        Assert.assertEquals(mdrdResult.getText(), "103.91 мл/мин/1.73м2 - Нормальный уровень СКФ (C1)");
        Assert.assertEquals(cgeResult.getText(), "125.7 мл/мин");
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();

    }
}
