package algorithms.misc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TextWrapperTest {

    private TextWrapper wrapper;

    @BeforeMethod
    public void before() {
        this.wrapper = new TextWrapper();
    }

    @Test
    public void testTokenize() {
        List<String> parts = wrapper.tokenize("abc def ghi jklmn", 5);
        Assert.assertEquals(parts.size(), 4);
        Assert.assertEquals(Arrays.asList("abc", "def", "ghi", "jklmn"), parts);
    }

    @Test
    public void testTokenizeLongerLines() {
        List<String> parts = wrapper.tokenize("abc def ghi jklmn", 10);
        Assert.assertEquals(parts.size(), 2);
        Assert.assertEquals(Arrays.asList("abc def", "ghi jklmn"), parts);
    }

    @Test
    public void testWrap() {
        String wrapped = wrapper.wrap("abc def\nghi\njklmn", 10);
        Assert.assertEquals(wrapped.split("\n").length, 3);

        String wrapped2 = wrapper.wrap("abc def\nghi\njklmn", 5);
        Assert.assertEquals(wrapped2, "abc\ndef\nghi\njklmn");

        String[] wrappedLines = wrapped2.split("\n");
        Assert.assertEquals(wrappedLines.length, 4);
        Assert.assertEquals(wrappedLines[0], "abc");
        Assert.assertEquals(wrappedLines[1], "def");
        Assert.assertEquals(wrappedLines[2], "ghi");
        Assert.assertEquals(wrappedLines[3], "jklmn");
    }

    @Test
    public void testWrapLong() {

    }
}
