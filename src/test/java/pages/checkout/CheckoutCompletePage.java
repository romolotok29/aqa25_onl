package pages.checkout;

import baseEntities.BasePage;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {

    private final By completeTitleLocator = By.xpath("//span[text()='Checkout: Complete!']");
    private final By completeHeaderLocator = By.cssSelector(".complete-header");
    private final By completeMessageLocator = By.cssSelector(".complete-text");
    private final By backButtonLocator = By.cssSelector("#back-to-products");

    private final String pagePath = "checkout-complete.html";

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return completeTitleLocator;
    }

    @Override
    public String getPageUrl() {
        return ReadProperties.url() + pagePath;
    }


    public WebElement getCompleteTitle(){
        return waitsService.waitForVisibility(completeTitleLocator);
    }

    public String getCompleteTitleText(){
        return getCompleteTitle().getText();
    }

    public WebElement getCompleteHeader() {
        return waitsService.waitForVisibility(completeHeaderLocator);
    }

    public String getCompleteHeaderText() {
        return getCompleteHeader().getText();
    }

    public WebElement getCompleteMessage() {
        return waitsService.waitForVisibility(completeMessageLocator);
    }

    public String getCompleteMessageText() {
        return getCompleteMessage().getText();
    }

    public WebElement getBackButton() {
        return waitsService.waitForVisibility(backButtonLocator);
    }

    public boolean hasBackButton() {
        return getBackButton().isDisplayed();

    }
}
