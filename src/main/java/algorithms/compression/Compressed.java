package algorithms.compression;

import java.util.Arrays;

public class Compressed {
    private final int[] ints;
    private final String[] dictionary;

    public Compressed(String[] dictionary, int[] ints) {
        this.ints = ints;
        this.dictionary = dictionary;
    }

    public int[] getInts() {
        return Arrays.copyOf(ints, ints.length);
    }

    public String[] getDictionary() {
        return Arrays.copyOf(dictionary, dictionary.length);
    }
}
