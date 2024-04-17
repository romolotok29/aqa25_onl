package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //Блок описания локаторов

    private final By usernameInputLocator = By.xpath("//input[@id = 'user-name']");
    private final By passwordInputLocator = By.xpath("//input[@id = 'password']");
    private final By loginButtonLocator = By.xpath("//input[@id = 'login-button']");

    //Блок инициализации

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return usernameInputLocator;
    }

    //Блок атомарных методов

    public WebElement getUsernameInput() {
        return waitsService.waitForVisibility(usernameInputLocator);
    }

    public WebElement getPasswordInput() {
        return waitsService.waitForVisibility(passwordInputLocator);
    }

    public WebElement getLoginButton() {
        return waitsService.waitForVisibility(loginButtonLocator);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

}
