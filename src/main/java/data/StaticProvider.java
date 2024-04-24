package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "projectName")
    public static Object[][] projectName() {
        return new Object[][]{
                {"Testing"},
        };
    }
}
