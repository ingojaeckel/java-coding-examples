package algorithms.compression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Uncompressed {
    private final String text;
    private final List<String> tokens;

    public Uncompressed(String text) {
        this.text = text;
        this.tokens = Arrays.asList(text.split("\\b"));
    }

    public List<String> getTokens() {
        return new ArrayList<String>(tokens);
    }

    public String getText() {
        return text;
    }
}
