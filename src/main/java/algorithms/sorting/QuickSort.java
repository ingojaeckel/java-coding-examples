package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public List<T> sort(List<T> unsorted) {
        List<T> sorted = new ArrayList<>(unsorted);
        sort(sorted, 0, sorted.size() - 1);
        return sorted;
    }

    private void sort(List<T> list, final int p, final int r) {
        if (p >= r) {
            return;
        }

        int q = partition(list, p, r);
        sort(list, p, q - 1);
        sort(list, q + 1, r);
    }

    protected int partition(List<T> list, final int left, final int right) {
        final T x = list.get(right); // pivot element
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) { // from beginning to one before the pivot element
            if (list.get(j).compareTo(x) <= 0) {
                i++; // number of elements smaller/equal to pivot
                swap(list, i, j);
            }
        }
        // r is still the index of the pivot element
        // i is the last element that was <= x.
        swap(list, i + 1, right);
        return i + 1;
    }
}
