package stepsDefinition;

import baseEntities.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import services.BrowserService;

import java.io.ByteArrayInputStream;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@Listeners(AllureTestNg.class)
public class Hook extends BaseTest {

    private BaseTest baseTest;

    public Hook(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Before()
    public void initGuiScenario() {
        baseTest.driver = new BrowserService().getDriver();

        allureEnvironmentWriter(ImmutableMap.<String, String>builder()
                .put("Browser", "Chrome")
                .put("Browser.Version", "128.0.6613.120")
                .put("Stand", "QA1")
                .build());

        //product = new Product("Sauce Labs Bolt T-Shirt");
    }

    @After()
    public void guiTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
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
            System.out.println("Scenario failed: " + scenario.getName());
            try {
                Allure.addAttachment("Screenshot on Failure",
                        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Closing service");
    }

}