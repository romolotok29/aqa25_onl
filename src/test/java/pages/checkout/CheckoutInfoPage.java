package pages.checkout;

import com.codeborne.selenide.SelenideElement;
import models.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutInfoPage {

    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By postalCodeInputLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");

    public SelenideElement getFirstNameInput() {
        return $(firstNameInputLocator);
    }

    public SelenideElement getLastNameInput() {
        return $(lastNameInputLocator);
    }

    public SelenideElement getPostalCodeInput() {
        return $(postalCodeInputLocator);
    }

    public SelenideElement getContinueButton() {
        return $(continueButtonLocator);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public CheckoutOverviewPage fillCheckoutInfo(User user) {
        getFirstNameInput().setValue(user.getFirstName());
        getLastNameInput().setValue(user.getLastName());
        getPostalCodeInput().setValue(user.getPostalCode());
        clickContinueButton();

        return new CheckoutOverviewPage();
    }
}
