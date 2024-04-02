package Data;

import org.testng.annotations.DataProvider;

public class GeneralDoubleDataProvider {

    @DataProvider(name = "doubleGeneralData")
    public static Object [][] divisionDoubleData() {
        return new Object[][] {
                {10.50, 2.10, 5.0},
                {16.44, -4.13, -3.980629539951574},
                {30.45, 30.45, 1.0},
                {-10.50, -2.10, 5.0},
                {148.983, 1.0, 148.983},
                {0.0, 67.38, 0.0}

        };
    }
}
