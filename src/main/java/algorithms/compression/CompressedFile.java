package algorithms.compression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CompressedFile {
    private Compressed compressed;
    private String fileName;

    private CompressedFile(String filename, Compressed compressed) {
        this.fileName = filename;
        this.compressed = compressed;
    }

    public Compressed getCompressed() {
        return compressed;
    }

    public String getFileName() {
        return fileName;
    }

    public void writeToDisk() throws Exception {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(fileName))) {
            // Write header: length of dictionary + length of integers
            String[] dictionary = compressed.getDictionary();
            w.write(dictionary.length);
            int[] ints = compressed.getInts();
            w.write(ints.length);

            // Write body: dictionary + integers
            for (int i = 0; i < dictionary.length; i++) {
                w.write(dictionary[i]);
                w.write("\n");
            }

            for (int i = 0; i < ints.length; i++) {
                w.write(ints[i]);
            }

            w.flush();
        }
    }

    public static CompressedFile from(String path) throws Exception {
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            int dictionaryLength = r.read();
            int intsLength = r.read();

            final String[] dictionary = new String[dictionaryLength];
            for (int i = 0; i < dictionaryLength; i++) {
                dictionary[i] = r.readLine();
            }
            final int[] ints = new int[intsLength];
            for (int i = 0; i < intsLength; i++) {
                ints[i] = r.read();
            }

            return new CompressedFile(path, new Compressed(dictionary, ints));
        }
    }

    public static CompressedFile from(String name, Compressed compressed) {
        return new CompressedFile(name, compressed);
    }
}
