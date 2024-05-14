package pages.checkout;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {

    private final String pagePath = "/checkout-step-two.html";

    private final By finishButtonLocator = By.id("finish");

    public SelenideElement getFinishButton() {
        return $(finishButtonLocator);
    }

    public void clickFinishButton() {
        getFinishButton().click();
    }

}
