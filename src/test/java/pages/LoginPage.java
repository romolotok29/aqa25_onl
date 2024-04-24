package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final static String pagePath = "";

    //Блок описания локаторов

    private final By emailInputLocator = By.xpath("//input[@id='name']");
    private final By passwordInputLocator = By.xpath("//input[@id = 'password']");
    private final By loginButtonLocator = By.xpath("//button[@id = 'button_primary']");

    private final By errorTextLabelLocator = By.xpath("//div[@class='error-text']");

    //Блок инициализации

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Блок атомарных методов

    @Override
    protected By getPageIdentifier() {
        return emailInputLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public WebElement getEmailInput() {
        return waitsService.waitForVisibility(emailInputLocator);
    }

    public LoginPage setEmail(String value) {
        getEmailInput().sendKeys(value);
        return this;
    }

    public WebElement getPasswordInput() {
        return waitsService.waitForVisibility(passwordInputLocator);
    }

    public LoginPage setPassword(String value) {
        getPasswordInput().sendKeys(value);
        return this;
    }

    public WebElement getLoginButton() {
        return waitsService.waitForVisibility(loginButtonLocator);
    }

    public WebElement getErrorTextLabel() {
        return waitsService.waitForVisibility(errorTextLabelLocator);
    }

    public String getErrorText() {
        return getErrorTextLabel().getText();
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void login(String email, String password) {
        setEmail(email)
                .setPassword(password)
                        .clickLoginButton();
    }

    public DashboardPage successfulLogin(String email, String password) {
        login(email, password);
        return new DashboardPage(driver, true);
    }

    public LoginPage incorrectLogin(String email, String password) {
        login(email, password);
        return this;

    }
}
