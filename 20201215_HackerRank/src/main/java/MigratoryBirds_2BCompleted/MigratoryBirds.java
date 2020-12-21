package MigratoryBirds_2BCompleted;
// this task should be completed!

import java.util.*;

public class MigratoryBirds {
    private static Collection<Integer> birds = new ArrayList<>();
    private static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) {
        Collections.addAll(birds, 1, 1, 2, 2, 3, 3, 3, 3, 2, 2, 5, 5, 6);

        for (Integer i : birds) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.putIfAbsent(i, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> e : entries) {
            System.out.printf("key: %d, val: %d \n", e.getKey(), e.getValue());
        }
        // we should use TreeMap here to sort our HashMap!
        // i should read more about TreeSet


        List<Map.Entry<Integer, Integer>> entriesList = convertSetToList(entries);
//        System.out.println(Collections.sort(entriesList,new BirdsComparator()));

    }

    public static void count(Integer number, Integer counter) {

    }

    public static <T> List<T> convertSetToList(Set<T> set) {
        // create an empty list
        List<T> list = new ArrayList<>();

        // push each element in the set into the list
        for (T t : set)
            list.add(t);

        // return the list
        return list;
    }
}

