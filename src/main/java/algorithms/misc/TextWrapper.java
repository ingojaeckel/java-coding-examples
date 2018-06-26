package algorithms.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextWrapper {
    public String wrap(String input, int maxLineLength) {
        String[] lines = input.split("\n");
        StringBuffer buf = new StringBuffer(input.length());

        for (String line : lines) {
            if (line.length() <= maxLineLength) {
                // Length of line is below threshold. Nothing to do.
                buf.append(line);
            } else {
                // Truncate line.
                List<String> tokens = tokenize(line, maxLineLength);
                for (int i=0; i<tokens.size(); i++) {
                    buf.append(tokens.get(i));
                    if (i < tokens.size()-1) {
                        buf.append("\n");
                    }
                }
            }
            buf.append("\n");
        }

        return buf.toString().trim();
    }

    public List<String> tokenize(String line, int maxLineLength) {
        if (line.length() <= maxLineLength) {
            return Arrays.asList(line);
        }
        int numberOfParts = line.length() / maxLineLength + 1;
        List<String> parts = new ArrayList<>(numberOfParts);

        String[] tokens = line.split(" ");
        StringBuffer buf = new StringBuffer();
        int len = 0;

        for (String t: tokens) {
            if (len < maxLineLength) {
                if (len + t.length() <= maxLineLength) {
                    // There is still enough space to add another token.
                    buf.append(t);
                    buf.append(" ");
                    len += t.length() + 1;
                } else {
                    // This token would push us above the configured threshold.
                    // Append what we have so far and add the current part to the next token.
                    parts.add(buf.toString().trim());

                    buf = new StringBuffer(t);
                    buf.append(" ");
                    len = t.length();
                }
            } else {
                // Reached max length of line.
                parts.add(buf.toString().trim());

                buf = new StringBuffer(t);
                buf.append(" ");
                len = t.length();
            }
        }

        if (buf.length() != 0) {
            parts.add(buf.toString().trim());
        }

        return parts;
    }
}
