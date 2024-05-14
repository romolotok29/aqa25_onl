package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SingleProductPage {

    private final By addToCartButton = By.id("add-to-cart");
    private final By shoppingCartButtonLocator = By.xpath("//*[@class = 'shopping_cart_link']");

    public SelenideElement getAddToCartButton() {
        return $(addToCartButton);
    }

    public SelenideElement getShoppingCartButton() {
        return $(shoppingCartButtonLocator);
    }

    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    public void clickShoppingCartButton() {
        getShoppingCartButton().click();
    }
}
