import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "stepsDefinition",
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty.html"},
        tags = "@gui"
)
@Listeners(AllureTestNg.class)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
