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
        char[] chars = new char[]{'c', 'a' };
        List<String> p = shuffler.shuffle(chars);
        Assert.assertEquals(2, p.size());
        Assert.assertTrue(p.containsAll(Arrays.asList("ac", "ca")));
    }

    @Test
    public void testWordShuffle() {
        List<String> p = shuffler.shuffle(new char[]{'c', 'a', 'n', 'e', 't' });
        Assert.assertEquals(1 * 2 * 3 * 4 * 5, p.size()); // = 120
        // p.forEach(s -> System.out.println(s));
    }

    @Test
    public void testWordShuffle2() {
        List<String> p = shuffler.shuffle(new char[]{'v', 'a', 'r', 'c', 'o', 't'});
        Assert.assertEquals(1 * 2 * 3 * 4 * 5 * 6, p.size()); // = 720
        // p.forEach(s -> System.out.println(s));
    }
}
