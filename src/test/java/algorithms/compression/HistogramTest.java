package algorithms.compression;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HistogramTest extends AbstractCompressionTest {
    @Test
    public void fiveWordTest() {
        Map<String, Integer> wordToFrequency = new HashMap<>();
        wordToFrequency.put("a", 3);
        wordToFrequency.put("b", 4);
        wordToFrequency.put("c", 2);
        wordToFrequency.put("foo", 1);
        wordToFrequency.put(" ", 5);

        Histogram histogram = new Histogram(wordToFrequency);

        Assert.assertEquals(histogram.getDictionary(), new String[] {" ", "b", "a", "c", "foo"});
        Assert.assertEquals(histogram.getFrequency(), new int[] {5, 4, 3, 2, 1});
    }
    
    @Test
    public void textFileTest() {
        
    }
}
