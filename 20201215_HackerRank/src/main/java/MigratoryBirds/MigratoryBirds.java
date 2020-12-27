package MigratoryBirds;

import java.util.*;

public class MigratoryBirds {
    private static List<Integer> birds = new ArrayList<>();
    private static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) {
        Collections.addAll(birds, 1, 1, 2, 2, 3, 3, 3, 3, 2, 2, 5, 5, 4);
        int result = migratoryBirds(birds);
        System.out.println(result);

    }

    static int migratoryBirds(List<Integer> arr) {
        for (Integer i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.putIfAbsent(i, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int currentKey = 1;
        int currentValue = 0;
        for (Map.Entry<Integer, Integer> e : entries) {
            if (e.getValue() > currentValue) {
                currentKey = e.getKey();
                currentValue = e.getValue();
            }

            System.out.printf("key: %d, val: %d \n", e.getKey(), e.getValue());
        }
        return currentKey;
    }
}

