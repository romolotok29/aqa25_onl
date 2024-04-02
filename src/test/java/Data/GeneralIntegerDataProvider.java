package Data;

import org.testng.annotations.DataProvider;

public class GeneralIntegerDataProvider {

    @DataProvider(name = "intGeneralData")
    public static Object [][] divisionIntData() {
        return new Object[][] {
                {60, 10, 6},
                {-20, 4, -5},
                {-30, -30, 1},
                {81, 1, 81},
                {0, 10, 0}
        };
    }
}
