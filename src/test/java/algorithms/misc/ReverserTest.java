package algorithms.misc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReverserTest {
    @DataProvider(name = "integerBaseCases")
    public Object[][] integerBaseCases() {
        return new Object[][]{
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{-1, -1},
                new Object[]{123, 321},
                new Object[]{321, 123},
                new Object[]{1024, 4201},
                new Object[]{Integer.MAX_VALUE, 0},
                new Object[]{Integer.MIN_VALUE, 0},
        };
    }

    @DataProvider(name = "stringBaseCases")
    public Object[][] stringBaseCases() {
        return new Object[][]{
                new Object[]{null, null},
                new Object[]{"", ""},
                new Object[]{"a", "a"},
                new Object[]{"ab", "ba"},
                new Object[]{"abcde", "edcba"}
        };
    }

    @Test
    public void testInteger() {
        Assert.assertEquals(Math.abs(Integer.MIN_VALUE), Integer.MIN_VALUE);
        Assert.assertEquals(Math.abs(Integer.MAX_VALUE), Integer.MAX_VALUE);
    }

    @Test(dataProvider = "integerBaseCases")
    public void testReverseInteger(int input, int expectedOutput) {
        Assert.assertEquals(Reverser.reverseInteger(input), expectedOutput);
    }

    @Test(dataProvider = "stringBaseCases")
    public void testReverseString(String input, String expectedOutput) {
        Assert.assertEquals(Reverser.reverseString(input), expectedOutput);
    }
}
