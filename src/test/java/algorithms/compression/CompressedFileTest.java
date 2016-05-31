package algorithms.compression;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompressedFileTest extends AbstractCompressionTest {
    @DataProvider(name = "testData")
    public Object[][] testData() throws Exception {
        return new Object[][] {new Object[] {"a b a aaa b a b"}, new Object[] {getTestData()}};
    }

    @Test(dataProvider = "testData")
    public void writeToDisk(String text) throws Exception {
        String fileName = "compressed-" + System.currentTimeMillis();

        HistogramCompression compression = new HistogramCompression();
        CompressedFile file = CompressedFile.from(fileName, compression.compress(new Uncompressed(text)));
        file.writeToDisk();

        Uncompressed uncompressed = compression.uncompress(CompressedFile.from(fileName).getCompressed());

        Assert.assertEquals(uncompressed.getText(), text);

        new File(fileName).deleteOnExit();
    }
}
