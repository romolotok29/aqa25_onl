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

    @Before
    public void initGuiScenario(Scenario scenario) {
        baseTest.driver = new BrowserService().getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            System.out.println("Attach screenshot");
        }
        baseTest.driver.quit();
    }

}