package algorithms.searching;

import java.util.*;

public class KBiggest {

    /**
     * @param list The input list.
     * @param k Number of elements that should be returned.
     * @return The k biggest elements in the given list.
     * @throws IllegalArgumentException If k > len(list) || k < 0.
     */
    public List<Integer> find(List<Integer> list, int k) throws IllegalArgumentException {
        if (list == null || k < 0 || k > list.size()) {
            throw new IllegalArgumentException();
        }

        SortedSet<Integer> result = new TreeSet<>();

        for (int element: list) {
            if (result.size() < k) {
                result.add(element);
                continue;
            }
            // result.size() >= k
            if (biggerThanOneOf(element, result)) {
                result.remove(result.first());
                result.add(element);
            }
        }

        return new ArrayList<>(result);
    }

    private boolean biggerThanOneOf(int element, SortedSet<Integer> set) {
        // Potential short cuts for edge cases: is the given elements smaller/greater than the first/last element in the sorted set?
        if (element < set.first()) {
            return false;
        }
        if (element > set.last()) {
            return true;
        }
        // Is the given element greater than any of the elements in the set?
        return set.stream().filter(k -> element > k).findAny().isPresent();
    }
}
