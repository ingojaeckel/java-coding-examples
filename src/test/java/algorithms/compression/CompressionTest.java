package algorithms.compression;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompressionTest extends AbstractCompressionTest {
    private HistogramCompression compression;

    @BeforeMethod
    public void setup() {
        this.compression = new HistogramCompression();
    }

    @Test
    public void compressionTest() throws Exception {
        Compressed compressed = compression.compress(new Uncompressed(getTestData()));

        String[] dictionary = compressed.getDictionary();
        System.out.format("dictionary [size=%d]:%n", dictionary.length);
        for (int i = 0; i < dictionary.length; i++) {
            System.out.format("[%d] \"%s\"%n", i, dictionary[i]);
        }
        System.out.println();
        System.out.println("Compressed:");
        System.out.print("[");
        int[] ints = compressed.getInts();
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            if (i < ints.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
