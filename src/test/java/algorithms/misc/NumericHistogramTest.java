package algorithms.misc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumericHistogramTest {

    private NumericHistogram histogram;

    @BeforeMethod
    public void setup() {
        this.histogram = new NumericHistogram();
    }

    @DataProvider(name = "validExamples")
    public Object[][] validExamples() {
        return new Object[][]{
            new Object[]{Arrays.asList(0, 1, 2, 3), 1, new int[]{4}},
            new Object[]{Arrays.asList(0, 1, 2, 3), 2, new int[]{2, 2}},
            new Object[]{Arrays.asList(0, 1, 2, 3), 4, new int[]{1, 1, 1, 1}},

            new Object[]{Arrays.asList(1, 2, 3, 4), 2, new int[]{2, 2}},

            new Object[]{Arrays.asList(1, 1, 2, 2, 3, 4), 2, new int[]{4, 2}},

            new Object[]{Arrays.asList(1, 1, 2, 2, 3, 4, 5, 10, 20), 3, new int[]{7, 1, 1}},
            new Object[]{Arrays.asList(1, 1, 2, 2, 3, 4, 5, 19, 20), 3, new int[]{7, 0, 2}},
            new Object[]{Arrays.asList(1, 1, 2, 2, 3, 4, 18, 19, 20), 3, new int[]{6, 0, 3}},
        };
    }

    @Test
    public void testEmpty() {
        Assert.assertEquals(histogram.calculate(new ArrayList<>(), 2).length, 0);
    }

    @Test(dataProvider = "validExamples")
    public void testExamples(List<Integer> list, int numberBuckets, int[] expectedHistogram) {
        Assert.assertEquals(histogram.calculate(list, numberBuckets), expectedHistogram);
    }
}
