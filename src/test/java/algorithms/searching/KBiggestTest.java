package algorithms.searching;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KBiggestTest {
    private KBiggest service;

    @BeforeMethod
    public void setup() {
        this.service = new KBiggest();
    }

    @DataProvider(name = "invalidArguments")
    public Object[][] invalidArguments() {
        return new Object[][]{
                new Object[]{null, 1},
                new Object[]{new ArrayList<>(), 1},
                new Object[]{new ArrayList<>(), -1},
                new Object[]{Arrays.asList(1), 2}
        };
    }

    @DataProvider(name = "smallExamples")
    public Object[][] smallExamples() {
        return new Object[][]{
                new Object[]{Arrays.asList(1, 12, 3, 5, -5, 5, 10, 15), 1, Arrays.asList(15)},
                new Object[]{Arrays.asList(1, 12, 3, 5, -5, 5, 10, 15), 5, Arrays.asList(3, 5, 10, 12, 15)},
                new Object[]{Arrays.asList(1, 12, 3, 5, -5, 5, 10, 15), 7, Arrays.asList(-5, 1, 3, 5, 10, 12, 15)},

        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "invalidArguments")
    public void testEmpty(List<Integer> list, int k) {
        service.find(list, k);
    }

    @Test(dataProvider = "smallExamples")
    public void testSmallExample(List<Integer> list, int k, List<Integer> result) {
        Assert.assertEquals(service.find(list, k), result);
    }
}
