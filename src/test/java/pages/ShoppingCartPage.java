package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.checkout.CheckoutInfoPage;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage {

    private final By checkoutButtonLocator = By.cssSelector("#checkout");

    public SelenideElement getCheckoutButton() {
        return $(checkoutButtonLocator);
    }

    public CheckoutInfoPage clickCheckoutButton() {
        getCheckoutButton().click();
        return new CheckoutInfoPage();
    }
}
