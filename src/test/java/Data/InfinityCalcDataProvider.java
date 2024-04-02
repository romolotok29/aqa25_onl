package Data;

import org.testng.annotations.DataProvider;

public class InfinityCalcDataProvider {

    @DataProvider(name = "InfinityDataProvider")
    public static Object [][] infinityData() {
        return new Object[][] {
                {52.9874, 0.0, Double.POSITIVE_INFINITY},
                {-52.9874, 0.0, Double.NEGATIVE_INFINITY},
                {999.88, 0, Double.POSITIVE_INFINITY},
                {-55, 0.0, Double.NEGATIVE_INFINITY},
                {0.0, 0, Double.NaN},
                {0, 0.0, Double.NaN},
        };
    }
}
