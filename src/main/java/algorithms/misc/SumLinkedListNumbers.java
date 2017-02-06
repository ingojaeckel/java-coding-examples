package algorithms.misc;

import java.util.List;

public class SumLinkedListNumbers {

    public int sum(List<Integer> list1, List<Integer> list2) {
        return map(list1) + map(list2);
    }

    private int map(List<Integer> list) {
        int n = 0;
        for (int i=0; i<list.size(); i++) {
            int index = list.size() - i - 1;
            int val = list.get(index);

            n += val * (int) Math.pow(10.0, i);
        }
        return n;
    }
}
