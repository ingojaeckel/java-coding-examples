package algorithms.searching;

import java.util.List;

interface Search<K extends Comparable<K>, V> {
    V find(List<Entry<K, V>> list, K key);
}
