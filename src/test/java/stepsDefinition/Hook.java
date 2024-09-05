package stepsDefinition;

import baseEntities.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import models.Product;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import services.BrowserService;

import java.io.ByteArrayInputStream;

public class Hook extends BaseTest {

    private BaseTest baseTest;

    public Hook(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Before()
    public void initGuiScenario() {
        baseTest.driver = new BrowserService().getDriver();
        product = new Product("Sauce Labs Bolt T-Shirt", "1");
    }

    @After()
    public void guiTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Сценарий провален: " + scenario.getName());
            try {
                Allure.addAttachment("Screenshot on Failure",
                        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        baseTest.driver.quit();
    }

    @Before(value = "@api", order = 10002)
    public void initApiScenario(Scenario scenario) {
        baseTest.service = scenario.getName();
        System.out.println("Инициализируем сервис");
    }

    @After(value = "@api")
    public void apiTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Attach screenshot");
        }

        System.out.println("Closing service");
    }

}