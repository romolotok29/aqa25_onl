package Data;

import org.testng.annotations.DataProvider;

public class AdditionalDoubleDataProvider {

    @DataProvider(name = "doubleAdditionalData")
    public static Object [][] additionalDoubleDivision() {
        return new Object[][] {
                {-25.0, 5.0, -5.0},
                {31.4732, 90.33, 0.348424665116794},
        };
    }
}
