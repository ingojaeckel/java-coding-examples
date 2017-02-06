package algorithms.misc;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> getElements(int n) {
        List<String> items = new ArrayList<>(15);
        for (int i=1; i<=n; i++) {
            items.add(map(i));
        }
        return items;
    }

    private String map(int i) {
        if (i % 5 == 0) {
            return "buzz";
        }
        if (i % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(i);
    }
}
