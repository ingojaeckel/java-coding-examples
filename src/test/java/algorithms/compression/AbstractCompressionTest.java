package algorithms.compression;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class AbstractCompressionTest {
    protected String getTestData() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("uncompressed.txt")));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }
}
