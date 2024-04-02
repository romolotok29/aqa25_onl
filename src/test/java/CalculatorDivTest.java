import Data.*;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorDivTest extends BaseCalcTest {

    @Test(testName = "Division of type int", dataProvider = "intGeneralData",
            dataProviderClass = GeneralIntegerDataProvider.class, timeOut = 1500, groups = "general")
    public void intDiv(int a, int b, int expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Division of type double", dataProvider = "doubleGeneralData",
            dataProviderClass = GeneralDoubleDataProvider.class, groups = "general")
    public void doubleDiv(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Additional int division", dataProvider = "intAdditionalData",
            dataProviderClass = AdditionalIntegerDataProvider.class,
            invocationCount = 2, threadPoolSize = 2, dependsOnMethods = "intDiv",
            groups = "additional")
    public void divIntExtended(int a, int b, int expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Additional double division", dataProvider = "doubleAdditionalData",
            dataProviderClass = AdditionalDoubleDataProvider.class,
            invocationCount = 2, invocationTimeOut = 1000,
            dependsOnMethods = "doubleDiv", groups = "additional")
    public void divDoubleExtended(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Int by Zero",
            expectedExceptions = ArithmeticException.class, dependsOnMethods = "intDiv", groups = "general")
    public void intDivByZero() {
        calculator.div(85, 0);
    }

    @Test(testName = "Double by Zero", description = "Specially falling test",
            expectedExceptions = ArithmeticException.class, groups = "general")
    public void doubleDivGetZero() {
        calculator.div(16.73, 0.0);
    }

    @Test(testName = "Infinity Double by Zero", dataProvider = "InfinityDataProvider",
            dataProviderClass = InfinityCalcDataProvider.class,
            dependsOnMethods = "doubleDivGetZero", alwaysRun = true, groups = "general")
    public void doubleDivByZero(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test(testName = "Integer by double", dependsOnGroups = "additional")
    public void intDivDouble() {
        Assert.assertEquals(calculator.div(5, 2.15), 2.3255813953488373);
    }

    @Test(testName = "Zero div by zero", enabled = false, expectedExceptions = ArithmeticException.class)
    public void doubleZeroZero() {
        Assert.assertEquals(calculator.div(0.0, 0.0), 0.0);
    }

    @Test(description = "Test with IRetryAnalyzer interface", retryAnalyzer = Retry.class)
    public void retryTest() {
        Assert.assertEquals(calculator.div(80, 5), 15);
    }

    @Parameters({"dividend", "divisor", "expected quotient"})
    @Test(description = "Using @Parameters annotation in Test", testName = "Double by int", priority = 1)
    public void doubleDivInteger(@Optional("54.9812923") double dividend, @Optional("9") int divisor, @Optional("6.109032477777777") double quotient) {
        Assert.assertEquals(calculator.div(dividend, divisor), quotient);
    }
}
