package algorithms.compression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractCompressionTest {
    private static String testData;

    public AbstractCompressionTest() {
        try (InputStreamReader is = new InputStreamReader(AbstractCompressionTest.class.getClassLoader().getResourceAsStream("uncompressed.txt"))) {
            BufferedReader reader = new BufferedReader(is);
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            testData = builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String getTestData() {
        return testData;
    }
}
