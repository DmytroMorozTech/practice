// We have a HashMap<Character, Optional<Character>>.
// Keys of this HashMap form some word. But we know, that Map is unordered Collection.
// So, how do we find out the order of letter in this word?
// The thing is that each entry of HashMap contains info about current letter (key),
// and reference to the next letter in this word (value)

// TASK: To reconstruct the word from keys of HashMap.

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static HashMap<Character, Optional<Character>> data() {
        return new HashMap<Character, Optional<Character>>() {{
            put('E', Optional.empty());
            put('U', Optional.of('K'));
            put('R', Optional.of('A'));
            put('K', Optional.of('R'));
            put('I', Optional.of('N'));
            put('A', Optional.of('I'));
            put('N', Optional.of('E'));
        }};
        // in this very sample the word that is stored in HashMap is "UKRAINE".
    }

    public static String reconstruct(HashMap<Character, Optional<Character>> map) {
        Set<Map.Entry<Character, Optional<Character>>> entries = map.entrySet();
        Character lastChar = entries.stream().filter(e -> !e.getValue().isPresent()).findFirst().get().getKey();

        int counter = entries.size();
        List<Character> result = new ArrayList<>();
        result.add(lastChar);

        map.remove(lastChar);
        for (int i = 0; i < counter - 1; i++) {
            Character prevChar = findPrevChar(map, lastChar);
            result.add(prevChar);
            lastChar = prevChar;
        }

        Collections.reverse(result);
        return result.stream().map(Object::toString).collect(Collectors.joining());

    }

    public static Character findPrevChar(HashMap<Character, Optional<Character>> map, Character currentChar) {
        Set<Map.Entry<Character, Optional<Character>>> entries = map.entrySet();
        Character prevChar = entries.stream().filter(e -> e.getValue().get() == currentChar).findFirst().get().getKey();
        return prevChar;
    }

    public static void main(String[] args) {
        System.out.println(reconstruct(data()));
    }
}
