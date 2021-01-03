package CharacterCoordinates;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static class Item {
        final Character letter;
        final Integer pos;

        Item(Character letter, Integer pos) {
            this.letter = letter;
            this.pos = pos;
        }
    }

    static class Items {
        final Character letter;
        final List<Integer> poss;

        public Items(Character letter, List<Integer> poss) {
            this.letter = letter;
            this.poss = poss;
        }
    }

    public static void main(String[] args) {
        String s = "Hello, my dear friend, please keep learning, I'll guarantee you'll " +
                "reach the moment you understand everything";
        IntStream.range(0, s.length())
                 .mapToObj(i -> new Item(s.charAt(i), i))
                 .collect(Collectors.groupingBy(
                         x -> x.letter, // we select the field that will be used as a key in
                         // resulting Map
                         Collectors.mapping(
                                 y -> y.pos,
                                 // we select a field that should be mapped from each obj.
                                 Collectors.toList())
                         // we select the type of collector that we want to use to form
                         // final value in our Map field "value";
                          )
                          // at this point we'll get a Map<Character, List<Integer>>
                 )
                 .entrySet().stream()
                 .map(e -> new Items(e.getKey(), e.getValue()))
                 .sorted(Comparator.comparingInt(o -> -o.poss.size()))
                 // here we sort the stream of Items (objects) according to the number of occurrences of
                 // each concrete letter. So far that o.poss is a List<Integer> that contains all
                 // indexes of some letter occurrences, o.poss.size() will contain the total number of
                 // occurrences of some particular letter.
                 .forEach(i -> System.out.printf("%c:%d:%s\n", i.letter, i.poss.size(), i.poss));
    }
}


/**
 * "Hello, my dear friend, please keep learning, I'll guarantee you'll reach the moment you
 * understand everything"
 * <p>
 * Expected output: e:16:<2,12,19,26,29,32,33,37,58,59,69,76,81,92,100,102>
 * l:8:<3,4,25,36,48,49,65,66> n:8:<20,40,42,56,82,90,97,108> r:7:<14,17,39,54,68,93,103>
 * a:7:<13,27,38,53,55,70,96> t:5:<57,74,83,95,105> i:4:<18,41,46,107> h:4:<1,72,75,106>
 * u:4:<52,63,87,89> d:4:<11,21,91,98> y:4:<9,61,85,104> o:4:<5,62,79,86> g:3:<43,51,109>
 * m:3:<8,78,80> s:2:<28,94> p:2:<24,34> k:1:<31> f:1:<16> c:1:<71> v:1:<101>
 */