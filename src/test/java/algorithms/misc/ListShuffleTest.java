package algorithms.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListShuffleTest {
    @Test
    public void testEmptyList() {
        Assert.assertTrue(new ListShuffle().shuffle(Collections.emptyList()).isEmpty());
    }

    @Test
    public void testShuffle() {
        List<Integer> unshuffled = Arrays.asList(1, 2, 3, 4);
        List<Integer> shuffled = new ListShuffle().shuffle(unshuffled);

        Assert.assertEquals(4, shuffled.size());
        Assert.assertTrue(shuffled.containsAll(unshuffled));
        Assert.assertNotEquals(unshuffled, shuffled);
    }
}
