package algorithms.misc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WordShuffleTest {

    private WordShuffle shuffler;

    @BeforeMethod
    public void before() {
        shuffler = new WordShuffle();
    }

    @Test
    public void testTwoLetterWordShuffle() {
        List<String> p = shuffler.shuffle("ca");
        Assert.assertEquals(p.size(), 2);
        Assert.assertTrue(p.containsAll(Arrays.asList("ac", "ca")));
    }

    @Test
    public void testWordShuffle() {
        List<String> p = shuffler.shuffle("canet");
        Assert.assertEquals(p.size(), 1 * 2 * 3 * 4 * 5); // = 120
        // p.forEach(s -> System.out.println(s));
    }

    @Test
    public void testWordShuffle2() {
        List<String> p = shuffler.shuffle("varcot");
        Assert.assertEquals(p.size(), 1 * 2 * 3 * 4 * 5 * 6); // = 720
        // p.forEach(s -> System.out.println(s));
    }
}
