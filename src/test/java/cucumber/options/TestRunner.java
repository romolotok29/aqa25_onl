package cucumber.options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "stepsDefinition.StepsDefinition")
public class TestRunner extends AbstractTestNGCucumberTests {
}
