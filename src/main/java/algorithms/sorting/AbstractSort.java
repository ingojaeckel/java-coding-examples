package algorithms.sorting;

import java.util.List;

abstract public class AbstractSort<T extends Comparable<T>> {
    protected void swap(List<T> list, int from, int to) {
        try {
            T tmp = list.get(to);
            list.set(to, list.get(from));
            list.set(from, tmp);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    abstract public List<T> sort(List<T> unsorted);

}
