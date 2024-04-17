package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.checkout.CheckoutInformationPage;
import pages.checkout.CheckoutOverviewPage;

public class CheckoutSteps extends BaseSteps {

    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    public void fillCheckoutInfo(String firstName, String lastName, String zipcode) {
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.getFirstNameInput().sendKeys(firstName);
        checkoutInformationPage.getLastNameInput().sendKeys(lastName);
        checkoutInformationPage.getPostalCodeInput().sendKeys(zipcode);
        checkoutInformationPage.getContinueButton().click();
    }

    public void finishCheckout() {
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getFinishButton().click();

    }
}




