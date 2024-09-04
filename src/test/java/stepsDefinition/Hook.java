package stepsDefinition;

import baseEntities.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import services.BrowserService;

public class Hook extends BaseTest {

    private BaseTest baseTest;

    public Hook(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Before(value = "@gui", order = 10002)
    public void initGuiScenario1(Scenario scenario) {
        baseTest.driver = new BrowserService().getDriver();
    }

    @Before(value = "@gui and @smoke", order = 10001)
    public void initGuiScenario2(Scenario scenario) {
        baseTest.driver = new BrowserService().getDriver();
    }

    @Before(value = "@api")
    public void initApiScenario(Scenario scenario) {
        baseTest.service = scenario.getName();
        System.out.println("Инициализируем сервис");
    }

    @After(value = "@gui")
    public void guiTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Attach screenshot");
        }

        baseTest.driver.quit();
    }

    @After(value = "@api")
    public void apiTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Attach screenshot");
        }

        System.out.println("Closing service");
    }

}