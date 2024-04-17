package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {

    private final By checkoutButtonLocator = By.cssSelector("#checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }

    public WebElement getCheckoutButton() {
        return waitsService.waitForVisibility(checkoutButtonLocator);
    }

}
