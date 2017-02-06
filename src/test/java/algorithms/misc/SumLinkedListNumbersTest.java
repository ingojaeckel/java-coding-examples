package algorithms.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SumLinkedListNumbersTest {
    @Test
    public void test() {
        Assert.assertEquals(new SumLinkedListNumbers().sum(Arrays.asList(1, 0, 0), Arrays.asList(1, 2, 3)), 223);
    }
}
