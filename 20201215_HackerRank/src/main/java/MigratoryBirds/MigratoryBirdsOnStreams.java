package MigratoryBirds;

import java.util.*;
import java.util.stream.Collectors;

public class MigratoryBirdsOnStreams {
    private static List<Integer> birds = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(birds, 1, 1, 2, 2, 3, 3, 3, 3, 2, 2, 5, 5, 4);
        int result = migratoryBirds(birds);
        System.out.println(result);

    }

    static int migratoryBirds(List<Integer> arr) {
        List<Map.Entry<Integer, Long>> collect = arr
                .stream()
                .collect(Collectors.groupingBy(
                        i -> Integer.valueOf(i),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(x -> -x.getValue()))
                .collect(Collectors.toList());

        System.out.println(collect);

        return (int) collect.get(0).getKey();
    }
}

