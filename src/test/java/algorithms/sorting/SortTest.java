package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import algorithms.sorting.BubbleSort;
import algorithms.sorting.QuickSort;
import algorithms.sorting.SelectionSort;

public class SortTest {
    @DataProvider(name = "algorithms")
    public Object[][] algorithms() {
        List<List<Integer>> inputs =
                Arrays.asList(Arrays.<Integer>asList(), Arrays.asList(1, 1, 1), Arrays.asList(-3, +2, -1), Arrays.asList(5, 1, 2, 3, 4),
                        Arrays.asList(5, 4, 1, 2, 3));
        List<String> outputs = Arrays.asList("[]", "[1, 1, 1]", "[-3, -1, 2]", "[1, 2, 3, 4, 5]", "[1, 2, 3, 4, 5]");
        List<AbstractSort<Integer>> algorithms =
                Arrays.<AbstractSort<Integer>>asList(new BubbleSort<Integer>(), new QuickSort<Integer>(), new RandomizedQuickSort<Integer>(),
                        new SelectionSort<Integer>());

        Object[][] params = new Object[inputs.size() * algorithms.size()][];

        for (int k = 0; k < inputs.size(); k++) {
            for (int i = 0; i < algorithms.size(); i++) {
                params[k * algorithms.size() + i] = new Object[] {inputs.get(k), algorithms.get(i), outputs.get(k)};
            }
        }
        return params;
    }

    @Test(dataProvider = "algorithms")
    public void test(List<Integer> input, AbstractSort<Integer> algorithm, String output) {
        List<Integer> sorted = algorithm.sort(input);
        Assert.assertEquals(sorted.toString(), output);
    }
}
