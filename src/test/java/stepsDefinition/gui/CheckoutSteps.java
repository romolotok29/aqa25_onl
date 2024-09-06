package stepsDefinition.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.User;
import org.testng.Assert;
import pages.checkout.CheckoutCompletePage;
import pages.checkout.CheckoutInfoPage;

public class CheckoutSteps extends BaseTest {

    private BaseTest baseTest;
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutCompletePage checkoutCompletePage;

    public CheckoutSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @And("fills in checkout information and clicks finish button")
    public void fillsInCheckoutInformationAndClicksFinishButton() {
        checkoutInfoPage = new CheckoutInfoPage(driver);

        User user = new User.Builder()
                .withUsername(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .withFirstName("Michael")
                .withLastName("Williams")
                .withPostalCode("102030")
                .build();

        checkoutInfoPage
                .fillCheckoutInfo(user)
                .finishCheckout();

    }

    @Then("checkout complete page with successful message and title should be displayed")
    public void checkoutCompleteMessageShouldBeDisplayed() {
        checkoutCompletePage = new CheckoutCompletePage(driver);

        Assert.assertTrue(checkoutCompletePage.isPageOpened());
        Assert.assertEquals(checkoutCompletePage.getCompleteTitleText(), "Checkout: Complete!");
        Assert.assertEquals(checkoutCompletePage.getCompleteMessageText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    }

    @Then("checkout complete page must have a Back Home button")
    public void checkoutCompletePageMustHaveBackHomeButton() {
        checkoutCompletePage = new CheckoutCompletePage(driver);

        Assert.assertTrue(checkoutCompletePage.hasBackHomeButton());
    }

}