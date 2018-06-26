package algorithms.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListShuffle {

    public <T> List<T> shuffle(List<T> input) {
        Random r = new Random();

        List<T> toChooseFrom = new ArrayList<>(input);
        List<T> shuffled = new ArrayList<>(input.size());

        for (int i=0; i<input.size(); i++) {
            int randomOffset = Math.abs(r.nextInt()) % toChooseFrom.size();

            shuffled.add(toChooseFrom.get(randomOffset));
            toChooseFrom.remove(randomOffset);
        }

        return shuffled;
    }
}
