import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

public class BaseCalcTest {

    protected Calculator calculator;

    @BeforeSuite
    public void myCalculator() {
        calculator = new Calculator();
    }

    @BeforeGroups(groups = {"general", "additional" })
    public void methodBeforeGeneral() {
        calculator = new Calculator();
    }
}
