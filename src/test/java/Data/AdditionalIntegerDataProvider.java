package Data;

import org.testng.annotations.DataProvider;

public class AdditionalIntegerDataProvider {

    @DataProvider(name = "intAdditionalData")
    public static Object [][] additionalIntDivision() {
        return new Object[][] {
                {14, -6, -2},
                {25, 50, 0},
        };
    }
}
