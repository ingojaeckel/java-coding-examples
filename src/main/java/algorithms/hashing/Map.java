package algorithms.hashing;

import java.util.Collection;

public interface Map<K, V> {
	V put(K key, V value);

	V get(K key);

	V remove(K key);

	boolean containsKey(K key);

	Collection<V> values();
}
