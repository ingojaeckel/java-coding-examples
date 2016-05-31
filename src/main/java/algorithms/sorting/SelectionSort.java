package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> {
	@Override
	public List<T> sort(List<T> unsorted) {
		List<T> sorted = new ArrayList<>(unsorted);

		for (int i = 0; i < sorted.size(); i++) {
			int min = i;

			for (int k = i + 1; k < sorted.size(); k++) {
				T lhs = sorted.get(k);
				T rhs = sorted.get(min);

				if (lhs.compareTo(rhs) < 0) {
					min = k;
				}
			}

			if (i != min) {
				swap(sorted, i, min);
			}
		}

		return sorted;
	}
}
