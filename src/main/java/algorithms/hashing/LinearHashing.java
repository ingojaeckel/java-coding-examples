package algorithms.hashing;

public class LinearHashing implements Hashable<String> {
	@Override
	public int hash(String value) {
		if (value == null) {
			return 0;
		}
		if (value.isEmpty()) {
			return 1;
		}

		int hash = value.charAt(0) % TABLE_SIZE;

		for (int i = 1; i < value.length(); i++) {
			char c = value.charAt(i);
			hash = (hash * 32 + c) % TABLE_SIZE;
		}

		return hash;
	}
}
