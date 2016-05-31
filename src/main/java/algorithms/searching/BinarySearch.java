package algorithms.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch<K extends Comparable<K>, V> implements Search<K, V> {
    @Override
    public V find(List<Entry<K, V>> list, K key) {
        if (list.isEmpty()) {
            return null;
        }

        List<Entry<K, V>> copy = new ArrayList<>(list);
        Collections.sort(copy);

        return find(copy, key, 0, copy.size() - 1);
    }

    private V find(List<Entry<K, V>> list, K key, int fromInclusive, int toInclusive) {
        if (fromInclusive > toInclusive) {
            return null;
        }

        int middleIndex = (toInclusive + fromInclusive) / 2;
        Entry<K, V> middle = list.get(middleIndex);

        int compare = key.compareTo(middle.getKey());

        if (compare < 0) {
            return find(list, key, fromInclusive, middleIndex - 1);
        } else if (compare > 0) {
            return find(list, key, middleIndex + 1, toInclusive);
        } else {
            return middle.getValue();
        }
    }
}
