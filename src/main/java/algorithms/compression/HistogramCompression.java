package algorithms.compression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramCompression implements Compressable {
    @Override
    public Compressed compress(Uncompressed uncompressed) {
        return compress(uncompressed, new Histogram(count(uncompressed)));
    }

    private Map<String, Integer> count(Uncompressed uncompressed) {
        final Map<String, Integer> frequency = new HashMap<>();
        for (String value : uncompressed.getTokens()) {
            if (frequency.containsKey(value)) {
                frequency.put(value, frequency.get(value) + 1);
            } else {
                frequency.put(value, 1);
            }
        }
        return frequency;
    }

    private Compressed compress(final Uncompressed uncompressed, final Histogram histogram) {
        final List<String> values = uncompressed.getTokens();
        final int[] compressed = new int[values.size()];

        for (int i = 0; i < values.size(); i++) {
            String word = values.get(i);
            int position = histogram.positionInDictionary(word);
            if (position == -1) {
                throw new RuntimeException(String.format("Did not find '%s' in dictionary.", word));
            }
            compressed[i] = position;
        }

        return new Compressed(histogram.getDictionary(), compressed);
    }

    @Override
    public Uncompressed uncompress(Compressed compressed) {
        StringBuilder builder = new StringBuilder();

        int[] ints = compressed.getInts();
        String[] dictionary = compressed.getDictionary();

        for (int i = 0; i < ints.length; i++) {
            String uncompressed = dictionary[ints[i]];
            builder.append(uncompressed);
        }

        return new Uncompressed(builder.toString());
    }
}
