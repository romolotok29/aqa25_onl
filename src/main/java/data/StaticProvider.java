package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "project")
    public static Object[][] projectName() {
        return new Object[][]{
                {"Testing with ValueOfObjects"},
        };
    }
}
