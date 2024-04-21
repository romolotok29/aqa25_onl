import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorsSauceDemoTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
        Thread.sleep(2000);
        driver.findElement(By.name("user-name")).sendKeys(ReadProperties.getUserName());
        driver.findElement(By.id("password")).sendKeys(ReadProperties.getPassword());
        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "Header logo")
    public void headerTest() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".app_logo")).isDisplayed());
    }

    @Test(testName = "Menu sections")
    public void menuSectionsTest() throws InterruptedException {
        driver.findElement(By.className("bm-burger-button")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.linkText("About")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.partialLinkText("Reset App")).isDisplayed());
    }

    @Test(testName = "Show all items")
    public void allItemsTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='about_sidebar_link']/preceding::a")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(testName = "Empty shopping cart")
    public void emptyCartTest() {
        driver.findElement(By.cssSelector(".primary_header .shopping_cart_container")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span")).getText(), "Your Cart");
        Assert.assertTrue(driver.findElement(By.cssSelector(".back.btn_medium")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.bm-burger-button")).isDisplayed());
    }

    @Test(testName = "Items sort A to Z")
    public void dropDownTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//option/parent::select")).isDisplayed());
    }

    @Test(testName = "Items container")
    public void itemPageTest() {
        driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(), 'Sly Pack')]")).getText(), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'price')]")).getText(), "$29.99");
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::img[@class='bm-icon']")).isDisplayed());
    }

    @Test(testName = "Add and remove item from shopping cart")
    public void addToCartTest() {
        driver.findElement(By.cssSelector("[name='add-to-cart-sauce-labs-backpack']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("[class$='cart_badge']")).getText(), "1");
        driver.findElement(By.cssSelector("[id*='cart_cont']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[id^='item_4_title']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[name|='remove']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class~='checkout_button']")).isDisplayed());
    }

    @Test(testName = "Footer")
    public void footerTest() {
        Assert.assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());
    }

    @Test(testName = "Social links")
    public void footerLinksTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//a/ancestor::ul")).isDisplayed());
    }

    @Test(testName = "Logout")
    public void logoutTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='about_sidebar_link']//following::a")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @AfterMethod()
    public void browserQuit() {
        driver.quit();
    }
}

