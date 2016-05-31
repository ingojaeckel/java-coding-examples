package algorithms.sorting;

import java.util.List;
import java.util.Random;

public class RandomizedQuickSort<T extends Comparable<T>> extends QuickSort<T> {
    private Random random = new Random(System.currentTimeMillis());

    @Override
    protected int partition(List<T> list, int p, int r) {
        int i = p + random.nextInt(r - p + 1);
        swap(list, i, r);
        return super.partition(list, p, r);
    }
}
