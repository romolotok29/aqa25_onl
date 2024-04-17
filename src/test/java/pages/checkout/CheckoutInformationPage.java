package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInformationPage extends BasePage {

    private final By firstNameInputLocator = By.cssSelector("#first-name");
    private final By lastNameInputLocator = By.cssSelector("#last-name");
    private final By postalCodeInputLocator = By.cssSelector("#postal-code");
    private final By continueButtonLocator = By.cssSelector("#continue");


    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return firstNameInputLocator;
    }


    public WebElement getFirstNameInput() {
        return waitsService.waitForVisibility(firstNameInputLocator);
    }

    public WebElement getLastNameInput() {
        return waitsService.waitForVisibility(lastNameInputLocator);
    }

    public WebElement getPostalCodeInput() {
        return waitsService.waitForVisibility(postalCodeInputLocator);
    }

    public WebElement getContinueButton() {
        return waitsService.waitForVisibility(continueButtonLocator);
    }

}
