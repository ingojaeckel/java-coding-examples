package algorithms.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordShuffle {
    public List<String> shuffle(String characters) {
        Set<Character> available = new HashSet<>();
        for (int i=0; i<characters.length(); i++) {
            available.add(characters.charAt(i));
        }

        return permutations(available);
    }

    private List<String> permutations(Set<Character> availableCharacters) {
        return permutation("", availableCharacters);
    }

    private List<String> permutation(final String prefix, final Set<Character> availableCharacters) {
        if (availableCharacters.isEmpty()) {
            return Arrays.asList(prefix);
        }

        return availableCharacters
                .stream()
                .map(c -> {
                    Set<Character> newAvailableCharacters = new HashSet<>(availableCharacters);
                    newAvailableCharacters.remove(c);

                    return permutation(prefix + c, newAvailableCharacters);
                })
                .flatMap(permutations -> permutations.stream())
                .collect(Collectors.toList());
    }
}
