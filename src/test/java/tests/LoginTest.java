package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

@Epic("Epic")
@Feature("Login feature")
public class LoginTest extends BaseTest {

    @Description("Successful login test")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "Логин тест с корректными данными")
    public void successfulLoginTest() {

        loginSteps
                .successfulLogin(user)
                .getProductByName(product)
                .shouldBe(visible);
    }

    @Description("Incorrect login test")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Логин тест с вводом некорректных данных")

    public void incorrectLoginTest() {

        loginSteps
                .incorrectLogin("unknownUser", user)
                .getErrorTextLabel()
                .shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Description("Locked out user login test")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Логин тест на проверку заблокированного пользователя")
    public void loginAsLockedUserTest() {

        loginSteps
                .loginAsLockedUser(lockedUser)
                .getErrorTextLockedOutUser()
                .shouldHave(exactText("Epic sadface: Sorry, this user has been locked out."));
    }
}
