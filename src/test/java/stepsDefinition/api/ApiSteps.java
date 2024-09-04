package stepsDefinition.api;

import baseEntities.BaseTest;
import io.cucumber.java.en.Given;

public class ApiSteps {

    private BaseTest baseTest;

    public ApiSteps(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Given("service is running")
    public void serviceIsRunning() {
        System.out.println(baseTest.service);
    }
}
