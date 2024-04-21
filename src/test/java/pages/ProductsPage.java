package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
    private final By productItemLocator = By.cssSelector(".inventory_item");
    private final By addToCartButtonLocator = By.cssSelector(".btn_inventory");
    private final By cartButtonLocator = By.cssSelector("#shopping_cart_container");
    private final int amountOfItemsOnPage = 6;


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return productItemLocator;
    }

    public Boolean isPageOpened() {
        return getAllProductsOnPage().size() == amountOfItemsOnPage;
    }

    public List<WebElement> getAllProductsOnPage() {
        return waitsService.waitForAllVisibleElementsLocatedBy(productItemLocator);
    }

    public WebElement getAddToCartButton(int index) {
        return waitsService.waitForAllVisibleElementsLocatedBy(addToCartButtonLocator).get(index);
    }

    public WebElement getCartButton() {
        return waitsService.waitForVisibility(cartButtonLocator);
    }


}
