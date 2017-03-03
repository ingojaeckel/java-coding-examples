package algorithms.compression;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Histogram {
    private final int[] frequency;
    private final String[] dictionary;

    public Histogram(final Map<String, Integer> wordToFrequency) {
        dictionary = new String[wordToFrequency.size()];
        frequency = new int[wordToFrequency.size()];

        int i = 0;
        for (Entry<String, Integer> entry : sortByValues(wordToFrequency).entrySet()) {
            dictionary[i] = entry.getKey();
            frequency[i++] = entry.getValue();
        }
    }

    private Map<String, Integer> sortByValues(final Map<String, Integer> frequency) {
        Map<String, Integer> sortedByValues = new TreeMap<>((lhs, rhs) -> {
            final int value = frequency.get(lhs).compareTo(frequency.get(rhs));
            if (value == 0) {
                // Prevent overriding values with the same frequency.
                return 1;
            }
            // Sort descending
            return -value;
        });
        sortedByValues.putAll(frequency);
        return sortedByValues;
    }

    public int positionInDictionary(String word) {
        // TODO use a map structure to avoid linear search.
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public String[] getDictionary() {
        return Arrays.copyOf(dictionary, dictionary.length);
    }

    public int[] getFrequency() {
        return Arrays.copyOf(frequency, frequency.length);
    }
}
