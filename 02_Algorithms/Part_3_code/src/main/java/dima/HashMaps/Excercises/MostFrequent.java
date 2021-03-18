// TASK:
// Find the most repeated element in an array of integers.
// Input: [1, 2, 2, 3, 3, 3, 4] Output: 3

package dima.HashMaps.Excercises;

import java.util.*;

public class MostFrequent {
    public static void main(String[] args) {

        // To find the most frequent item in an array, we have to count the
        // number of times each item has been repeated. We can use a hash
        // table to store the items and their frequencies.

        HashMap<Integer, Integer> table = new HashMap<>();
        int[] ints = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5};
        // with this input expected output should be: 5
        for (int numb : ints) {
            if (!table.containsKey(numb)) {
                table.put(numb, 1);
                continue;
            }
            Integer currentVal = table.get(numb);
            table.put(numb, currentVal + 1);
        }

        int mostFrequentElemKey = -1;
        int mostFrequentElemVal = ints[0];
        for (Map.Entry<Integer, Integer> e : table.entrySet()) {
            if (e.getValue() > mostFrequentElemVal) {
                mostFrequentElemKey = e.getKey();
                mostFrequentElemVal = e.getValue();
            }
        }

//        int mostFrequentElemKey = maxUsingStreamAndMethodReference(table);

        System.out.printf("Most frequent elem in array of integers: %d \n", mostFrequentElemKey);
    }
//    -------------------------------------------------------------------------------------------
//    Once we've populated our hash table, we need to iterate over all
//    key/value pairs and find the one with the highest frequency.
//    We can use different approaches for that:

    public static <K, V extends Comparable<V>> K maxUsingIteration(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    public static <K, V extends Comparable<V>> K maxUsingCollectionsMaxAndLambda(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = Collections.max(map.entrySet(), (Map.Entry<K, V> e1, Map.Entry<K, V> e2) -> e1.getValue()
                .compareTo(e2.getValue()));
        return maxEntry.getKey();
    }

    public static <K, V extends Comparable<V>> K maxUsingCollectionsMaxAndComparator(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = Collections.max(map.entrySet(), Comparator.comparing(Map.Entry::getValue));
        return maxEntry.getKey();
    }

    public static <K, V extends Comparable<V>> K maxUsingStreamAndMethodReference(Map<K, V> map) {
        Optional<Map.Entry<K, V>> maxEntry = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get()
                .getKey();
    }
}
