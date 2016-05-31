package algorithms.hashing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unchecked")
public class HashMap<V> implements Map<String, V> {

	private Hashable<String> hashable = new LinearHashing();

	private Object[] table = new Object[Hashable.TABLE_SIZE];

	@Override
	public V put(String key, V value) {
		int hash = hashable.hash(key);

		if (table[hash] == null) {
			table[hash] = value;
			return null;
		}

		V previousValue = (V) table[hash];
		table[hash] = value;
		return previousValue;
	}

	@Override
	public V remove(String key) {
		int hash = hashable.hash(key);

		if (table[hash] == null) {
			return null;
		}

		V previousValue = (V) table[hash];
		table[hash] = null;
		return previousValue;
	}

	@Override
	public V get(String key) {
		int hash = hashable.hash(key);

		if (table[hash] == null) {
			return null;
		}

		return (V) table[hash];
	}

	@Override
	public boolean containsKey(String key) {
		return table[hashable.hash(key)] != null;
	}

	@Override
	public Collection<V> values() {
		List<V> values = new ArrayList<>(table.length);

		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				values.add((V) table[i]);
			}
		}

		return values;
	}
}
