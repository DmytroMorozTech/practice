package JavaDeque;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> ints = new ArrayList<>(Arrays.asList(5, 3, 5, 2, 3, 2));
        int n = ints.size(); // N of numbers in array
        int m = 3; // the size of subarray

        List<Integer> numbOfUniqueVals = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int current = ints.get(i);
            set.add(current);
            deque.addLast(current);

            if (deque.size() == m) {
//                System.out.println(deque);
                numbOfUniqueVals.add(set.size());
                Integer removedElem = deque.removeFirst();
                System.out.println(removedElem);

                set.clear();

                set.add(deque.getFirst());
                set.add(deque.getLast());
            }
        }

        Integer max = Collections.max(numbOfUniqueVals);

        System.out.println(max);
    }


}
