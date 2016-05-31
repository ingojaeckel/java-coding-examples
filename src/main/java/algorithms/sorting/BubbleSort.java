package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	public List<T> sort(List<T> unsorted) {
		List<T> sorted = new ArrayList<>(unsorted);
		for (int i = 0; i < sorted.size(); i++) {
			for (int k = 0; k < sorted.size(); k++) {
				if (i == k) {
					continue;
				}

				T left = sorted.get(i);
				T right = sorted.get(k);

				if (left.compareTo(right) < 0) {
					swap(sorted, i, k);
				}
			}
		}

		return sorted;
	}

}
