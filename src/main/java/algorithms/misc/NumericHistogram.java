package algorithms.misc;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class NumericHistogram {

    public int[] calculate(Collection<Integer> items, int buckets) {
        if (items.isEmpty()) {
            return new int[0];
        }
        if (buckets == 1) {
            return new int[]{items.size()};
        }

        SortedSet<Integer> sorted = new TreeSet<>(items);

        int[] histogram = new int[buckets];
        int valueRange = sorted.last() - sorted.first() + 1;
        int itemsPerBucket = valueRange / buckets;
        if (itemsPerBucket * buckets < sorted.last()) {
            // The division rounded down. Lets round this up instead.
            itemsPerBucket = itemsPerBucket + 1;
        }

        for (int value: items) {
            int valueZeroBased = value - sorted.first();
            int index = valueZeroBased / itemsPerBucket;
            histogram[index]++;
        }

        return histogram;
    }

}
