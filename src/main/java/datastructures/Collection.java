package datastructures;

public interface Collection<K extends Comparable<K>, V> {
    V insert(K key, V value);

    V remove(K key);

    V get(K key);
    
    String traverse();
    
    int size();
}
