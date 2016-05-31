package concurrency;

import algorithms.compression.AbstractCompressionTest;
import algorithms.compression.CompressedFile;
import algorithms.compression.HistogramCompression;
import algorithms.compression.Uncompressed;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class ParallelSumTest extends AbstractCompressionTest {
    private ParallelSum calculator;

    @BeforeMethod
    public void beforeTest() throws Exception {
        this.calculator = new ParallelSum();
    }

    @Test
    public void calculateSum() throws Exception {
        Assert.assertEquals(calculator.sum(new File("example_file.txt")), 18);
    }

    @Test
    public void calculateSumWithLambda() throws Exception {
        Assert.assertEquals(calculator.sumWithLambda(new File("example_file.txt")), 18);
    }

    @Test
    public void calculateSumWithMoreLambda() throws Exception {
        Assert.assertEquals(calculator.sumWithMoreLambda(new File("example_file.txt")), 18);
    }
}
