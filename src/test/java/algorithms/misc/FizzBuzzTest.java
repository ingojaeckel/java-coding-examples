package algorithms.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FizzBuzzTest {
    @Test
    public void testFizzBuzz() {
        Assert.assertEquals(new FizzBuzz().getElements(10), Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz"));
    }
}
