package pages.checkout;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletedPage {

    private final By completeTitleLocator = By.cssSelector(".title");
    private final By completeHeaderLocator = By.cssSelector(".complete-header");
    private final By completeTextLocator = By.cssSelector(".complete-text");
    private final By backHomeButtonLocator = By.cssSelector("#back-to-products");


    public SelenideElement getCompleteTitle() {
        return $(completeTitleLocator);
    }

    public SelenideElement getCompleteHeader() {
        return $(completeHeaderLocator);
    }

    public SelenideElement getCompleteText() { return $(completeTextLocator); }

    public SelenideElement getBackHomeButton() {
        return $(backHomeButtonLocator);
    }
}
