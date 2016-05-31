package algorithms.hashing;

public interface Hashable<T> {
	int hash(T value);

	int TABLE_SIZE = 128;
}
